package com.io.industry.industria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.industry.industria.domain.entity.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long>{
}
