package com.io.industry.industria.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "table_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", length = 50)
    @NotEmpty(message = "{username.not-empty}")
    private String username;

    @Column(name = "email", length = 50, unique = true)
    @NotEmpty(message = "{email.not-empty}")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "{password.not-empty}")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Machine> machine;

}
