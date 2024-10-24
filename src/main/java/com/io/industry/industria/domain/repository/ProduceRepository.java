package com.io.industry.industria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.io.industry.industria.domain.entity.Produce;

@Repository
public interface ProduceRepository extends JpaRepository<Produce, Long>{
    
    @Query(value = " SELECT * FROM produce p JOIN produce_machine pm ON p.produce_id = pm.produce_produce_id WHERE pm.machine_machine_id=:id", nativeQuery = true) 
    List<Produce> findByMachineId(@Param("id") Long machineId);

}
