package com.example.demo.service;

import com.example.demo.domain.Favorito;
import com.example.demo.dto.favorito.FavoritoEntradaDTO;
import com.example.demo.dto.favorito.FavoritoSalidaDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FavoritoService {

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