package com.example.cine.repositories;

import com.example.cine.models.Function;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface FunctionRepository extends CrudRepository<Function, Serializable> {
}
