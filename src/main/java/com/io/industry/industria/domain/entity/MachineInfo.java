package com.io.industry.industria.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "machine_info")
public class MachineInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_info_id")
    private Long id;

    @Column(name = "temperature")
    @NotNull(message = "{info.temperature.not-empty}")
    private Integer temperature;

    @Column(name = "info_time")
    private LocalDateTime infoTime;

    public MachineInfo() {
        this.temperature = 0;
        this.infoTime = LocalDateTime.now();
    }

}
