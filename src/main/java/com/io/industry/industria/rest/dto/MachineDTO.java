package com.io.industry.industria.rest.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineDTO {
    
    @NotEmpty(message = "{name.not-empty}")
    @Length(max = 50, min = 4)
    private String name;

    @Length(max = 50, min = 4)
    private String model = "1.0";

    private List<Long> produceList;

    private Long currentProduceId;

    public MachineDTO(String name, String model) {
        this.name = name;
        this.model = model;
        this.produceList = new ArrayList<Long>();
    }

}
