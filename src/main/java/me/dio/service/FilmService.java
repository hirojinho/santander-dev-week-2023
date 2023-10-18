package me.dio.service;

import me.dio.domain.model.Film;

public interface FilmService {
    
    Iterable<Film> buscarTodos();
    Film buscarPorId(Long id);
    void inserir(Film film);
    void deletar(Long id);
}
