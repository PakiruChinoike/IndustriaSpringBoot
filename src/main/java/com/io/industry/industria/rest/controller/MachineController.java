package com.io.industry.industria.rest.controller;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.io.industry.industria.domain.entity.Machine;
import com.io.industry.industria.domain.entity.MachineInfo;
import com.io.industry.industria.domain.entity.Notification;
import com.io.industry.industria.domain.enums.Alert;
import com.io.industry.industria.rest.dto.MachineDTO;
import com.io.industry.industria.service.MachineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/machine")
public class MachineController {
    
    @Autowired
    private MachineService service;

    @GetMapping("/public/{id}")
    public Machine getMachineById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/public/user/{id}")
    public List<Machine> getMachineByUserId(@PathVariable Long id) {
        return service.findByUserId(id);
    }

    @GetMapping("/public/email/{email}")
    public List<Machine> getMachineByUserEmail(@PathVariable String email) {
        return service.findByUserEmail(email);
    }

    @GetMapping("/public")
    public List<Machine> getAllMachine() {
        return service.findAll();
    }

    @PostMapping("/private")
    @ResponseStatus(CREATED)
    public Machine postMachine(@RequestBody @Valid MachineDTO dto) {
        return service.save(dto);
    }

    @PostMapping("/private/{id}")
    @ResponseStatus(CREATED)
    public void updateMachine(@RequestBody MachineDTO dto, @PathVariable Long id) {
        service.update(dto, id);
    }

    @DeleteMapping("/private/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteMachine(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/public/off/{id}")
    @ResponseStatus(CREATED)
    public Notification turnOff(@PathVariable Long id) {
        service.turnOff(id);
        return new Notification(Alert.OFF, id);
    }

    @PutMapping("/public/on/{id}")
    @ResponseStatus(CREATED)
    public Notification turnOn(@PathVariable Long id) {
        service.turnOn(id);
        return new Notification(Alert.ON, id);
    }

    @PutMapping("/private/info/{id}")
    @ResponseStatus(CREATED)
    public Machine updateInfo(@RequestBody @Valid MachineInfo info, @PathVariable Long id) {
        return service.updateInfo(info, id);
    }

    @PutMapping("/public/current/{id}")
    @ResponseStatus(CREATED)
    public Machine updateProduce(@RequestBody MachineDTO dto, @PathVariable Long id) {
        return service.updateProduce(
            dto.getCurrentProduceId(), id);
    }

    @PutMapping("/public/list/{id}")
    @ResponseStatus(CREATED)
    public Machine updateProduceList(@RequestBody MachineDTO dto, @PathVariable Long id) {
        return service.updateProduceList(
            dto.getProduceList(), id);
    }

}
