package com.example.cine;

import com.example.cine.models.Genre;
import com.example.cine.services.genres.GenreService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GenreServiceTest {

    @Autowired
    private GenreService service;

    @Test
    @Transactional
    @Rollback
    public void thatWhenCreatingGeneroShouldObtainOneGenero(){
        Genre genre = dadoQueTengoUnGenero("Terror");
        guardoElGeneroEnLaDB(genre);
        Genre genreSalvado = buscoElGeneroQueSeGuardo(genre);
        entoncesVerificoQueLosGenerosSeanLosMismos(genre, genreSalvado);
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedeObtenerTodosLosGeneros(){
        Genre gen1 = dadoQueTengoUnGenero("Terror");
        Genre gen2 = dadoQueTengoUnGenero("Ciencia Ficción");
        this.service.crearGenero(gen1);
        this.service.crearGenero(gen2);
        entoncesVerificoQueSeDevuelvanTodosLosGeneros();
    }

    private void entoncesVerificoQueSeDevuelvanTodosLosGeneros() {
        assertThat(this.service.findAll().size()).isEqualTo(2);
    }

    private void entoncesVerificoQueLosGenerosSeanLosMismos(Genre genre, Genre genreSalvado) {
        assertThat(genreSalvado.getName()).isEqualTo(genre.getName());
    }

    private Genre buscoElGeneroQueSeGuardo(Genre genre) {
        return this.service.findGeneroByName(genre.getName());
    }

    private void guardoElGeneroEnLaDB(Genre genre) {
        this.service.crearGenero(genre);
    }

    private Genre dadoQueTengoUnGenero(String genero) {
        Genre gen = new Genre();
        gen.setName(genero);
        return gen;
    }
}
