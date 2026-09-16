package com.example.demo.repository.favorito;

import com.example.demo.domain.Favorito;

import java.util.List;
import java.util.Optional;

public interface FavoritoRepository {

    List<Favorito> findAll();

    Optional<Favorito> findById(Long id);

    Favorito save(Favorito favorito);

    void deleteById(Long id);
}