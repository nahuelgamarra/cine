package com.example.cine.services.company;

import com.example.cine.models.Company;

import java.util.List;

public interface CompanyService {

    public Company createdCompany(Company cmp);

    public List<Company> findAll();
}
