package com.example.cine.services.movie;

import com.example.cine.models.Movie;
import com.example.cine.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService{

    @Autowired
    private MovieRepository repository;

    @Override
    public Movie createMovie(Movie mv) {
        return this.repository.save(mv);
    }

    @Override
    public List<Movie> findAll() {
        return (List<Movie>) this.repository.findAll();
    }
}
