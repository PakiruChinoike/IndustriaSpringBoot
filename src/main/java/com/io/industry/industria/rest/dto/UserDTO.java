package com.io.industry.industria.rest.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    
    @NotEmpty(message = "{username.not-empty}")
    @Length(max = 50, min=4)
    private String username;
    
    @NotEmpty(message = "{email.not-empty}")
    @Length(max = 50)
    private String email;

    @NotEmpty(message = "{password.not-empty}")
    @Length(min = 6)
    private String password;

}
