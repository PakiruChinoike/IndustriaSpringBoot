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

import com.io.industry.industria.domain.entity.Notification;
import com.io.industry.industria.domain.entity.Produce;
import com.io.industry.industria.domain.enums.Alert;
import com.io.industry.industria.rest.dto.ProduceDTO;
import com.io.industry.industria.service.ProduceService;

import jakarta.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/produce")
public class ProduceController {
    
    @Autowired
    private ProduceService service;

    @GetMapping("/{id}")
    public Produce getProduceById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/machine/{id}")
    public List<Produce> getProduceByMachine(@PathVariable Long id) {
        return service.findByMachineId(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Produce postProduce(@RequestBody @Valid ProduceDTO dto) {
        return service.save(dto);
    }

    @PostMapping("/{id}")
    @ResponseStatus(CREATED)
    public void updateProduce(@RequestBody ProduceDTO dto, @PathVariable Long id) {
        service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduce(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/match/{id}")
    public Notification match(@RequestBody ProduceDTO dto, @PathVariable Long id) {
        boolean isMatch = service.match(dto, id);
        if(isMatch) {
            return null;
        } else {
            return new Notification(Alert.ERROR, id);
        }
    }

}
