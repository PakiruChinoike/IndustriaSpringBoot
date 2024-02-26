package com.io.industry.industria.rest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduceDTO {
    
    private Long machineId;

    @NotEmpty(message = "{name.not-empty}")
    private String name;

    @NotNull(message = "{x.not-empty}")
    private Float xLength;
    
    @NotNull(message = "{z.not-empty}")
    private Float zLength;

    @NotNull(message = "{y.not-empty}")
    private Float yLength;

}
