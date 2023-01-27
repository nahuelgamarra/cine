package com.example.cine.repositories;

import com.example.cine.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Serializable> {

}
