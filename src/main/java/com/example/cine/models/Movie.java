package com.example.cine.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idMovie;

    private String title;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pelicula_Compania",
            joinColumns = @JoinColumn(name = "idPelicula"),
            inverseJoinColumns = @JoinColumn(name = "idCompania"))
    private List<Company> listCompany;

    private LocalDateTime fechEstreno;

    private Boolean adult;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pelicula_Genero",
            joinColumns = @JoinColumn(name = "idPelicula"),
            inverseJoinColumns = @JoinColumn(name = "idGenero"))
    private List<Genre> genreList;
}
