package com.example.cine.services.genres;

import com.example.cine.models.Genres;
import com.example.cine.repositories.GeneroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("generoServicio")
@Transactional
public class GeneroServiceImp implements GeneroService{

    private GeneroRepository repo;

    @Autowired
    public GeneroServiceImp(GeneroRepository repo) {this.repo = repo;}

    @Override
    public Genres crearGenero(Genres genres) {return this.repo.save(genres);}

    @Override
    public List<Genres> findAll() {return (List<Genres>) this.repo.findAll();}

    @Override
    public Genres findGeneroByName(String name) {return this.repo.findGeneroByName(name);}
}
