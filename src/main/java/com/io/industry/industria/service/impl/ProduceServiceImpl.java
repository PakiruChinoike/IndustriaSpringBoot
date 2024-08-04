package com.io.industry.industria.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.io.industry.industria.domain.entity.Machine;
import com.io.industry.industria.domain.entity.Produce;
import com.io.industry.industria.domain.repository.MachineRepository;
import com.io.industry.industria.domain.repository.ProduceRepository;
import com.io.industry.industria.exception.ServiceRuleException;
import com.io.industry.industria.rest.dto.ProduceDTO;
import com.io.industry.industria.service.ProduceService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProduceServiceImpl implements ProduceService{
    
    private final ProduceRepository repository;
    private final MachineRepository machineRepository;

    @Override
    public Produce findById(Long id) {
        return repository.findById(
            id
        ).orElseThrow(() -> new ServiceRuleException("Id de produto não encontrado."));
    }

    @Override
    public List<Produce> findByMachineId(Long machineId) {
        return repository.findByMachineId(machineId);
    }

    @Override
    @Transactional
    public Produce save(ProduceDTO dto) {
        Produce produce = objectFromDto(dto);

        return repository.save(produce);
    }

    @Override
    @Transactional
    public void update(ProduceDTO dto, Long id) {
        Produce produce = objectFromDto(dto);

        repository.findById(id)
            .map(p -> {
                produce.setId(id);
                repository.save(produce);
                return p;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de produto não encontrado."));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.findById(id)
            .map(p -> {
                repository.delete(p);
                return p;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de produto não encontrado."));
    }

    @Override
    public boolean match(ProduceDTO dto, Long id) {
        Produce dbProduce = repository.findById(
            id
        ).orElseThrow(
            () -> new ServiceRuleException("Id de produto não encontrado"));
        dbProduce.setId(null);
        dbProduce.setMachine(null);
        
        Produce dtoProduce = objectFromDto(dto);
        dtoProduce.setMachine(null);

        return dbProduce==dtoProduce;
    }

    private Produce objectFromDto(ProduceDTO dto) {
        Machine machine = machineRepository.findById(
            dto.getMachineId()
        ).orElseThrow(() -> new ServiceRuleException("Id de máquina não encontrado."));

        return Produce.builder()
            .name(dto.getName())
            .xLength(dto.getXLength())
            .zLength(dto.getZLength())
            .yLength(dto.getYLength())
            .machine(machine)
            .build();
    }

}
