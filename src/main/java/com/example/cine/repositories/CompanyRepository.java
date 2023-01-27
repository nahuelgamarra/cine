package com.example.cine.repositories;

import com.example.cine.models.Company;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface CompanyRepository extends CrudRepository<Company, Serializable> {
}
