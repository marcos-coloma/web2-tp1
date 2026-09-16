package com.example.demo.service;

import com.example.demo.domain.Favorito;
import com.example.demo.dto.favorito.FavoritoEntradaDTO;
import com.example.demo.dto.favorito.FavoritoSalidaDTO;
import com.example.demo.repository.favorito.FavoritoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FavoritoService {

    private final FavoritoRepository favoritoRepository;

    public FavoritoService(FavoritoRepository favoritoRepository) {
        this.favoritoRepository = favoritoRepository;
    }

    public FavoritoSalidaDTO crear(FavoritoEntradaDTO dto) {
        Favorito favorito = convertirADominio(dto);

        return convertirASalida(favoritoRepository.save(favorito));
    }

    public List<FavoritoSalidaDTO> obtenerTodos() {
        return favoritoRepository.findAll()
                .stream()
                .map(this::convertirASalida)
                .toList();
    }

    public FavoritoSalidaDTO obtenerPorId(Long id) {
        Favorito favorito = favoritoRepository.findById(id)
                .orElseThrow();

        return convertirASalida(favorito);
    }

    public FavoritoSalidaDTO actualizar(Long id, FavoritoEntradaDTO dto) {
        Favorito favoritoActual = favoritoRepository.findById(id)
                .orElseThrow();

        Favorito favoritoActualizado = new Favorito(
                favoritoActual.id(),
                dto.productoId(),
                dto.nota(),
                favoritoActual.fechaAgregado()
        );

        return convertirASalida(favoritoRepository.save(favoritoActualizado));
    }

    public void eliminar(Long id) {
        favoritoRepository.deleteById(id);
    }



    private Favorito convertirADominio(FavoritoEntradaDTO dto) {
        return new Favorito(
                null,
                dto.productoId(),
                dto.nota(),
                LocalDateTime.now()
        );
    }

    private FavoritoSalidaDTO convertirASalida(Favorito favorito) {
        return new FavoritoSalidaDTO(
                favorito.id(),
                favorito.productoId(),
                favorito.nota(),
                favorito.fechaAgregado()
        );
    }
}