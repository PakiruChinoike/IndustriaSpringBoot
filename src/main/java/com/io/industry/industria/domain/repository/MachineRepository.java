package com.io.industry.industria.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.io.industry.industria.domain.entity.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long>{

    @Query(value = " SELECT * FROM Machine m JOIN tWHERE m.user=:id ", nativeQuery = true)
    List<Machine> findByUserId(@Param("id") Long id);

    @Query(value = " SELECT * FROM machine m JOIN table_user u ON m.user = u.user_id WHERE u.email=:email ", nativeQuery = true)
    List<Machine> findByUserEmail(@Param("email") String email);

}
