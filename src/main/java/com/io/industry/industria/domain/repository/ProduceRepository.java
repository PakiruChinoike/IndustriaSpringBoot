package com.io.industry.industria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.io.industry.industria.domain.entity.Produce;

@Repository
public interface ProduceRepository extends JpaRepository<Produce, Long>{
    
    @Query(" select p from Produce p where p.machine=:id ") 
    List<Produce> findByMachineId(@Param("id") Long machineId);

}
