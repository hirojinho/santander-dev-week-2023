package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.Film;
import me.dio.domain.repository.FilmRepository;
import me.dio.service.FilmService;

@Service
public class FilmServiceClass implements FilmService {
    
    private final FilmRepository filmRepository;

    public FilmServiceClass(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Iterable<Film> buscarTodos() {
        return filmRepository.findAll();
    }

    @Override
    public Film buscarPorId(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return film;
    }

    @Override
    public void inserir(Film film) {
        if(filmRepository.existsById(film.getId())){
            throw new IllegalArgumentException("This film ID already exists");
        }
        filmRepository.save(film);
    }

    @Override
    public void deletar(Long id) {
        filmRepository.deleteById(id);
    }
}
