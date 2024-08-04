package com.io.industry.industria.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.io.industry.industria.domain.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "machine")
public class Machine{

    //ENTIDADE PARA AS MÁQUINAS SALVAS NO BANCO DE DADOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id")
    private Long id;

    //STATUS (ON/OFF)
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull(message = "{status.not-null}")
    private Status status;

    //MOMENTO EM QUE A MÁQUINA FOI LIGADA
    @Column(name = "on_time")
    private LocalDateTime onTime;

    //MOMENTO EM QUE A MÁQUINA FOI DESLIGADA
    @Column(name = "off_time")
    private LocalDateTime offTime;

    //HÁ QUANTO TEMPO A MÁQUINA ESTÁ LIGADA
    @Column(name = "minute_running")
    private Integer minuteRunning;

    //INFORMAÇÕES ATUAIS DA MÁQUINA (APENAS TEMPERATURA ATUALMENTE)
    @OneToOne
    @JoinColumn(name = "machine_info_id", nullable = true)
    private MachineInfo currentInfo;

    //MODELO DA MÁQUINA
    @Column(name = "model", length = 100)
    private String model;

    //NOME DA MÁQUINA
    @Column(name = "name")
    @NotEmpty(message = "{name.not-null}")
    private String name;

    //LISTA DE PRODUTOS QUE A MÁQUINA É CAPAZ DE PRODUZIR
    @OneToMany(mappedBy = "machine")
    private List<Produce> produce;

    //PRODUTO ATUAL SENDO PRODUZIDO PELA MÁQUINA
    @OneToOne
    private Produce currentProduce;

    //USUÁRIO DA MÁQUINA CADASTRADA
    @ManyToOne
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;

}
