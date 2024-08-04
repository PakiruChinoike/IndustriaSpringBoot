package com.io.industry.industria.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "produce")
public class Produce {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produce_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "machine")
    @JsonIgnore
    private Machine machine;

    @Column(name = "name")
    private String name;

    @Column(name = "x_length")
    @Default
    private Float xLength = 1F;

    @Column(name = "z_length")
    @Default
    private Float zLength = 1F;

    @Column(name = "y_length")
    @Default
    private Float yLength = 1F;
}
