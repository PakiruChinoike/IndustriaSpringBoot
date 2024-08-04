package com.io.industry.industria.service;

import java.util.List;

import com.io.industry.industria.domain.entity.Produce;
import com.io.industry.industria.rest.dto.ProduceDTO;

public interface ProduceService {

    Produce findById(Long id);
    List<Produce> findByMachineId(Long machineId);
    Produce save(ProduceDTO dto);
    void update(ProduceDTO dto, Long id);
    void delete(Long id);
    boolean match(ProduceDTO dto, Long id);
    
}
