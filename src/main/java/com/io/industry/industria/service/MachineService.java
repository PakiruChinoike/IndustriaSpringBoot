package com.io.industry.industria.service;

import java.util.List;

import com.io.industry.industria.domain.entity.Machine;
import com.io.industry.industria.domain.entity.MachineInfo;
import com.io.industry.industria.rest.dto.MachineDTO;

public interface MachineService {
    
    Machine findById(Long id);
    List<Machine> findAll();
    Machine save(MachineDTO dto);
    void update(MachineDTO dto, Long id);
    void delete(Long id);
    Machine turnOff(Long id);
    Machine turnOn(Long id);
    Machine updateInfo(MachineInfo info, Long id);
    Machine updateProduce(Long produceId, Long id);
    Machine updateProduceList(List<Long> produceList, Long id);

}
