package com.example.cine.repositories;

import com.example.cine.models.Butaca;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ButacaRepository extends CrudRepository<Butaca, Serializable> {
}
