package com.example.cine.repositories;

import com.example.cine.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("generoRepositorio")
public interface GenreRepository extends CrudRepository<Genre, Long> {

    public Genre findGeneroByName(String name);
}
