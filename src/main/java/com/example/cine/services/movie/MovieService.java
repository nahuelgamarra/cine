package com.example.cine.services.movie;

import com.example.cine.models.Movie;

import java.util.List;

public interface MovieService {

    public Movie createMovie(Movie mv);

    public List<Movie> findAll();
}
