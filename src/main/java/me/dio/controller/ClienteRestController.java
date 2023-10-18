package me.dio.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.domain.model.Film;
import me.dio.service.FilmService;

/*
 * Aqui a gente pega as operações nas estruturas de dados da linguagem
 * e transforma em requisições HTTP
 */

@RestController
@RequestMapping("/films")
public class ClienteRestController {
    private final FilmService filmService;

    public ClienteRestController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Film>> buscarTodos() {
        return ResponseEntity.ok(filmService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Film> inserir(@RequestBody Film film) {
        /*
         * O @RequestBody está mapeando o parâmetro para uma requisição POST
         */
        filmService.inserir(film);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(film.getId())
                .toUri();
        return ResponseEntity.created(location).body(film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filmService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
