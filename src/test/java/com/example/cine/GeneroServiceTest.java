package com.example.cine;

import com.example.cine.models.Genres;
import com.example.cine.services.genres.GeneroService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GeneroServiceTest {

    @Autowired
    private GeneroService service;

    @Test
    @Transactional
    @Rollback
    public void thatWhenCreatingGeneroShouldObtainOneGenero(){
        Genres genres = dadoQueTengoUnGenero("Terror");
        guardoElGeneroEnLaDB(genres);
        Genres genresSalvado = buscoElGeneroQueSeGuardo(genres);
        entoncesVerificoQueLosGenerosSeanLosMismos(genres, genresSalvado);
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedeObtenerTodosLosGeneros(){
        Genres gen1 = dadoQueTengoUnGenero("Terror");
        Genres gen2 = dadoQueTengoUnGenero("Ciencia Ficción");
        this.service.crearGenero(gen1);
        this.service.crearGenero(gen2);
        entoncesVerificoQueSeDevuelvanTodosLosGeneros();
    }

    private void entoncesVerificoQueSeDevuelvanTodosLosGeneros() {
        assertThat(this.service.findAll().size()).isEqualTo(2);
    }

    private void entoncesVerificoQueLosGenerosSeanLosMismos(Genres genres, Genres genresSalvado) {
        assertThat(genresSalvado.getName()).isEqualTo(genres.getName());
    }

    private Genres buscoElGeneroQueSeGuardo(Genres genres) {
        return this.service.findGeneroByName(genres.getName());
    }

    private void guardoElGeneroEnLaDB(Genres genres) {
        this.service.crearGenero(genres);
    }

    private Genres dadoQueTengoUnGenero(String genero) {
        Genres gen = new Genres();
        gen.setName(genero);
        return gen;
    }
}
