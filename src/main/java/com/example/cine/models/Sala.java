package com.example.cine.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sala")
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idSala;

    @ManyToOne
    private Butaca butaca;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private TipoDeSala type;
}
