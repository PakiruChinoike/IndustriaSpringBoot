package com.io.industry.industria.domain.entity;

import com.io.industry.industria.domain.enums.Alert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    @Column(name = "message")
    @NotEmpty(message = "{message.not-empty}")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "alert")
    @NotNull(message = "{alert.not-empty}")
    private Alert alert;

    public Notification(Alert alert, Long id) {
        this.alert = alert;
        switch (alert) {
            case ERROR:
                this.message = "Erro encontrado em produto da máquina: " + id;
                break;
            case OFF:
                this.message = "Máquina desligada: " + id;
                break;
            case ON:
                this.message = "Máquina ligada: " + id;
                break;
            default:
                break;
        }

    }
    

}
