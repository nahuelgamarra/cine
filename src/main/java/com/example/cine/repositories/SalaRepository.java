package com.example.cine.repositories;
import com.example.cine.models.Sala;
import com.example.cine.models.TipoDeSala;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface SalaRepository extends CrudRepository<Sala, Serializable> {

    public List<Sala> findAllByTipo(TipoDeSala tipoDeSala);

}
