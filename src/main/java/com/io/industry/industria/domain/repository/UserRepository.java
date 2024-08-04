package com.io.industry.industria.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.io.industry.industria.domain.entity.Machine;
import com.io.industry.industria.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query(" select u from User u where u.username like :username ")
    List<User> findByUsernameLike(@Param("username") String username);

    @Query(" select u from User u where u.email=:email ")
    Optional<User> findByEmail(@Param("email") String email);

    @Query(" select m from Machine m where m.user=:id")
    List<Machine> findAllMachine(@Param("id") Long id);

}
