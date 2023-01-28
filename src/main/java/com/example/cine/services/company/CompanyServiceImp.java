package com.example.cine.services.company;

import com.example.cine.models.Company;
import com.example.cine.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImp implements CompanyService{

    @Autowired
    private CompanyRepository repository;

    @Override
    public Company createdCompany(Company cmp) {
        return this.repository.save(cmp);
    }

    @Override
    public List<Company> findAll() {
        return (List<Company>) this.repository.findAll();
    }
}
