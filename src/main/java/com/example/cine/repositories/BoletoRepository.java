package com.example.cine.repositories;

import com.example.cine.models.Boleto;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BoletoRepository extends CrudRepository<Boleto, Serializable> {
}
