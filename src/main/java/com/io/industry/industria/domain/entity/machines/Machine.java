package com.io.industry.industria.domain.entity.machines;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.io.industry.industria.domain.entity.AbstractMachine;
import com.io.industry.industria.domain.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Machine extends AbstractMachine{
    
    //MODELO DE MÁQUINA GENÉRICA E PROVISÓRIA
    //CADA TIPO DE MÁQUINA POSSUIR UMA CLASSE ESPECÍFICA BASEADA NESSA

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id")
    private Long id;

    @Column(name = "model", length = 100)
    private String model;

    @Column(name = "name")
    @NotEmpty(message = "{name.not-null}")
    private String name;

    @OneToMany(mappedBy = "machine")
    private List<Produce> produce;

    @OneToOne
    private Produce currentProduce;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;

}
