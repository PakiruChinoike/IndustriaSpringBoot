package com.io.industry.industria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.industry.industria.domain.entity.machines.MachineInfo;

public interface MachineInfoRepository extends JpaRepository<MachineInfo, Long>{
}
