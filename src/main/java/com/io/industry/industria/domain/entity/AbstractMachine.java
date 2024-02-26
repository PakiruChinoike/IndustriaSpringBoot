package com.io.industry.industria.domain.entity;

import java.time.LocalDateTime;

import com.io.industry.industria.domain.entity.machines.MachineInfo;
import com.io.industry.industria.domain.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "machine")
public abstract class AbstractMachine {

    //MODELO DE MÁQUINA ABSTRATA DA QUAL TODAS AS MÁQUINAS HERDAM SEUS ATRIBUTOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull(message = "{status.not-null}")
    private Status status;

    @Column(name = "on_time")
    private LocalDateTime onTime;

    @Column(name = "off_time")
    private LocalDateTime offTime;

    @Column(name = "minute_running")
    private Integer minuteRunning;

    @OneToOne
    @JoinColumn(name = "machine_info_id", nullable = true)
    private MachineInfo currentInfo;
    
}
