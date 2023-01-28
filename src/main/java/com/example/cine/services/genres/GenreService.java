package com.example.cine.services.genres;

import com.example.cine.models.Genre;
import java.util.List;

public interface GenreService {

    public Genre crearGenero(Genre genre);

    public List<Genre> findAll();

    public Genre findGeneroByName(String name);
}
