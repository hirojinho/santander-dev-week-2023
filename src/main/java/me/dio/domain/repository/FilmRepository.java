package me.dio.domain.repository;

import org.springframework.stereotype.Repository;

import me.dio.domain.model.Film;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    
}
