package com.example.cine.services.sala;

import com.example.cine.models.Sala;
import com.example.cine.models.TipoDeSala;

import java.util.List;

public interface SalaService {
    public void addSala(Sala newSala);

    public List<Sala> findAll();

    public Sala findSalaById(Long id);

    public List<Sala> findByTypeOfSala(TipoDeSala tipoDeSala);

}
