package com.example.cine.services.genres;

import com.example.cine.models.Genre;
import com.example.cine.repositories.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("generoServicio")
@Transactional
public class GenreServiceImp implements GenreService {

    private GenreRepository repo;

    @Autowired
    public GenreServiceImp(GenreRepository repo) {this.repo = repo;}

    @Override
    public Genre crearGenero(Genre genre) {return this.repo.save(genre);}

    @Override
    public List<Genre> findAll() {return (List<Genre>) this.repo.findAll();}

    @Override
    public Genre findGeneroByName(String name) {return this.repo.findGeneroByName(name);}
}
