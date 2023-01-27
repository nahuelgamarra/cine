package com.example.cine.services.genres;

import com.example.cine.models.Genres;
import java.util.List;

public interface GeneroService {

    public Genres crearGenero(Genres genres);

    public List<Genres> findAll();

    public Genres findGeneroByName(String name);
}
