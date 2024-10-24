package com.io.industry.industria.rest.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduceDTO {

    @NotEmpty(message = "{name.not-empty}")
    private String name;

    @NotNull(message = "{x.not-null}")
    private Float xLength;
    
    @NotNull(message = "{z.not-null}")
    private Float zLength;

    @NotNull(message = "{y.not-null}")
    private Float yLength;

    private List<Long> machineIdList;

}
