package com.io.industry.industria.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.io.industry.industria.domain.entity.User;
import com.io.industry.industria.rest.dto.UserDTO;
import com.io.industry.industria.service.UserService;

import jakarta.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping("/private/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/private")
    public List<User> getAllUser() {
        return service.findAll();
    }

    @GetMapping("/private/username/{username}")
    public List<User> getUserByUsernameLike(@PathVariable String username) {
        return service.findByUsernameLike(username);
    }

    @GetMapping("/private/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public User postUser(@RequestBody @Valid UserDTO dto) {
        return service.save(dto);
    } 

    @PostMapping("/public/{id}")
    @ResponseStatus(CREATED)
    public void updateUser(@RequestBody UserDTO dto, @PathVariable Long id) {
        service.update(dto, id);
    }

    @DeleteMapping("/public/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }
}
