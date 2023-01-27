package com.example.cine.repositories;

import com.example.cine.models.Genres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("generoRepositorio")
public interface GeneroRepository extends CrudRepository<Genres, Long> {

    public Genres findGeneroByName(String name);
}
