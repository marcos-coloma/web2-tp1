package com.example.demo.repository.favorito;

import com.example.demo.domain.Favorito;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryFavoritoRepository implements FavoritoRepository {

    private final List<Favorito> favoritos = new ArrayList<>();

    @Override
    public List<Favorito> findAll() {
        return favoritos;
    }

    @Override
    public Optional<Favorito> findById(Long id) {
        return favoritos.stream()
                .filter(favorito -> favorito.id().equals(id))
                .findFirst();
    }

    @Override
    public Favorito save(Favorito favorito) {
        favoritos.add(favorito);
        return favorito;
    }

    @Override
    public void deleteById(Long id) {
        favoritos.removeIf(favorito -> favorito.id().equals(id));
    }
}