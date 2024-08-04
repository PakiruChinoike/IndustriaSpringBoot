package com.io.industry.industria.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.io.industry.industria.domain.entity.Machine;
import com.io.industry.industria.domain.entity.User;
import com.io.industry.industria.domain.repository.UserRepository;
import com.io.industry.industria.exception.ServiceRuleException;
import com.io.industry.industria.rest.dto.UserDTO;
import com.io.industry.industria.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    private final UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new ServiceRuleException("Id de usuário não encontrado."));
    }

    @Override
    public List<User> findByUsernameLike(String username) {
        return repository.findByUsernameLike(username);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
            () -> new ServiceRuleException("E-mail de usuário não encontrado."));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Machine> findAllMachine(Long id) {
        return repository.findAllMachine(id);
    }

    @Override
    @Transactional
    public User save(UserDTO dto) {
        User user = objectFromDto(dto);

        return repository.save(user);
    }

    @Override
    @Transactional
    public void update(UserDTO dto, Long id) {
        User user = objectFromDto(dto);

        repository.findById(id)
            .map(u -> {
                user.setId(id);
                repository.save(user);
                return u;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de usuário não encontrado."));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.findById(id)
            .map(u -> {
                repository.delete(u);
                return u;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de usuário não encontrado"));
    }

    private User objectFromDto(@Valid UserDTO dto) {
        return User.builder()
            .username(dto.getUsername())
            .email(dto.getEmail())
            .password(dto.getPassword())
            .build();
    }

}
