package com.example.cine;

import com.example.cine.models.Company;
import com.example.cine.models.Genre;
import com.example.cine.models.Movie;
import com.example.cine.services.movie.MovieService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService service;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaCargarUnaPelicula(){
        Movie pel = dadoQueTengoUnaPelicula();
        System.out.println("pel = " + pel);
        this.service.createMovie(pel);
        List<Movie> peliculaGuardado = this.service.findAll();
        assertThat(peliculaGuardado.get(0).getIdMovie()).isEqualTo(pel.getIdMovie());
    }

    private Movie dadoQueTengoUnaPelicula() {
        Movie pel = new Movie();
        pel.setAdult(false);
        pel.setTitle("Club de la Pelea");
        pel.setDescription("Club de la Pelea");
        pel.setGenreList(dadoQueTengoUnaListaDeGeneros());
        pel.setFechEstreno(LocalDateTime.now());
        pel.setListCompany(dadoQueTengoUnaListaDeCompania("Compania1","Compania2"));
        return pel;
    }

    private List<Company> dadoQueTengoUnaListaDeCompania(String com1, String com2) {
        Company com = new Company();
        com.setName(com1);
        com.setOrigin(com1);
        Company com3 = new Company();
        com3.setName(com2);
        com3.setOrigin(com2);
        return List.of(com,com3);
    }

    private List<Genre> dadoQueTengoUnaListaDeGeneros() {
        Genre genre = new Genre();
        genre.setName("Pelea");
        Genre genre1 = new Genre();
        genre.setName("Acción");
        return List.of(genre,genre1);
    }

}
