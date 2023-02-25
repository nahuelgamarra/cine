package com.example.cine.repositories;

import com.example.cine.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("generoRepositorio")
public interface GenreRepository extends CrudRepository<Genre, Serializable> {

    public Genre findGeneroByName(String name);
}
