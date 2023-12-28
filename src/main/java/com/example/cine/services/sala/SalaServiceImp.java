package com.example.cine.services.sala;

import com.example.cine.models.Sala;
import com.example.cine.models.TipoDeSala;
import com.example.cine.repositories.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SalaServiceImp implements SalaService{

    @Autowired
    private SalaRepository repo;

    @Override
    public void addSala(Sala newSala) {
        this.repo.save(newSala);
    }

    @Override
    public List<Sala> findAll() {
        return (List<Sala>) this.repo.findAll();
    }

    @Override
    public Sala findSalaById(Long id) {
        return this.repo.findById(id).get(); //this.repo.findById(id).orElseThrow(SalaInvalidaException.class)
    }

    @Override
    public List<Sala> findByTypeOfSala(TipoDeSala tipoDeSala) {
String palabra= "nuevo";
        return this.repo.findAllByTipo(tipoDeSala);
    }
}
