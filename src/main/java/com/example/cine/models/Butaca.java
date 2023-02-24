package com.example.cine.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class Butaca implements Serializable { // 1 1 1

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nroUbicacion;


    @ManyToOne
    private Sala sala;

    private Boolean opcupado;
}
