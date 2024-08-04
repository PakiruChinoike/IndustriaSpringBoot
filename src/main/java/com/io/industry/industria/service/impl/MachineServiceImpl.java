package com.io.industry.industria.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.io.industry.industria.domain.entity.Machine;
import com.io.industry.industria.domain.entity.MachineInfo;
import com.io.industry.industria.domain.entity.Produce;
import com.io.industry.industria.domain.enums.Status;
import com.io.industry.industria.domain.repository.MachineInfoRepository;
import com.io.industry.industria.domain.repository.MachineRepository;
import com.io.industry.industria.domain.repository.ProduceRepository;
import com.io.industry.industria.exception.ServiceRuleException;
import com.io.industry.industria.rest.dto.MachineDTO;
import com.io.industry.industria.service.MachineService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MachineServiceImpl implements MachineService{
    
    private final MachineRepository repository;
    private final MachineInfoRepository infoRepository;
    private final ProduceRepository produceRepository;

    @Override
    public Machine findById(Long id) {
        return repository.findById(
            id
        ).orElseThrow(() -> new ServiceRuleException("Id de máquina não encontrado."));
    }

    @Override
    public List<Machine> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Machine save(MachineDTO dto) {
        Machine machine = objectFromDto(dto);

        return repository.save(machine);
    }

    @Override
    @Transactional
    public void update(MachineDTO dto, Long id) {
        Machine machine = objectFromDto(dto);

        repository.findById(id)
            .map(m -> {
                machine.setId(id);
                infoRepository.save(machine.getCurrentInfo());
                repository.save(machine);
                return m;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de máquina não encontrado."));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.findById(id)
            .map(m -> {
                infoRepository.delete(m.getCurrentInfo());
                repository.delete(m);
                return m;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de máquina não encontrado."));
    }

    @Override
    @Transactional
    public Machine turnOff(Long id) {
        return repository.findById(id)
            .map(m -> {
                m.setStatus(Status.OFF);
                m.setOffTime(LocalDateTime.now());
                return m;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de máquina não encontrado."));
    }

    @Override
    @Transactional
    public Machine turnOn(Long id) {
        return repository.findById(id)
            .map(m -> {
                m.setStatus(Status.ON);
                m.setOnTime(LocalDateTime.now());
                return m;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de máquina não encontrado."));
    }

    @Override
    @Transactional
    public Machine updateInfo(MachineInfo info, Long id) {
        return repository.findById(id)
            .map(m -> {
                info.setInfoTime(LocalDateTime.now());
                m.setCurrentInfo(info);
                infoRepository.save(m.getCurrentInfo());
                return m;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de máquina não encontrado."));
    }

    @Override
    @Transactional
    public Machine updateProduce(Long produceId, Long id) {
        return repository.findById(id)
            .map(m -> {
                Produce p = produceRepository
                    .findById(produceId)
                    .orElseThrow(() -> new ServiceRuleException("Id de produto não encontrado"));
                m.setCurrentProduce(p);
                
                List<Produce> produceList = m.getProduce();
                if(!produceList.contains(p)) {
                    produceList.add(p);
                    m.setProduce(produceList);
                }

                return repository.save(m);
            }).orElseThrow( 
                () -> new ServiceRuleException("Id de máquina não encontrado."));
    }

    @Override
    @Transactional
    public Machine updateProduceList(List<Long> produceList, Long id) {
        List<Produce> produce = produceList
            .stream()
            .map(p -> {
                return produceRepository.findById(p)
                    .orElseThrow(() -> new ServiceRuleException("Id de produto não encontrado."));
            }).collect(Collectors.toList());

        return repository.findById(id)
            .map(m -> {
                m.setProduce(produce);
                return repository.save(m);
            }).orElseThrow(
                () -> new ServiceRuleException("Id de máquina não encontrado."));
    }


    private Machine objectFromDto(MachineDTO dto) {
        Produce currentP;
        List<Produce> listProduce;
        MachineInfo info = infoRepository.save(new MachineInfo());

        if (dto.getCurrentProduceId()!=null) {
            currentP = produceRepository.findById(
                dto.getCurrentProduceId()
            ).orElseThrow(() -> new ServiceRuleException("Id de produto não encontrado."));
        } else {
            currentP = null;
        }

        if(!dto.getProduceList().isEmpty()) {
            listProduce = dto.getProduceList()
                .stream()
                .map(p -> {
                    return produceRepository.findById(p).orElseThrow(
                        () -> new ServiceRuleException("Id de produto não encontrado"));
                }).collect(Collectors.toList());
        } else {
            listProduce = new ArrayList<>();
        }

        Machine machine = Machine.builder()
            .name(dto.getName())
            .model(dto.getModel())
            .produce(listProduce)
            .currentProduce(currentP)
            .status(Status.OFF)
            .minuteRunning(0)
            .offTime(LocalDateTime.now())
            .currentInfo(info)
            .build();

        return machine;
    }
    

}
