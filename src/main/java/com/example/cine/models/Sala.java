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

    private Integer fil;

    private Integer cantCol;

   /* @ManyToOne
    private Butaca butacaList;
*/
    @Enumerated(EnumType.STRING)
    private TipoDeSala tipo;
}
