package com.io.industry.industria.service;

import java.util.List;

import com.io.industry.industria.domain.entity.Machine;
import com.io.industry.industria.domain.entity.User;
import com.io.industry.industria.rest.dto.UserDTO;

public interface UserService {
    
    User findById(Long id);
    List<User> findByUsernameLike(String username);
    User findByEmail(String email);
    List<Machine> findAllMachine(Long id);
    List<User> findAll();
    User save(UserDTO dto);
    void update(UserDTO dto, Long id);
    void delete(Long id);

}
