package com.example.demo.dto.favorito;

import java.time.LocalDateTime;

public record FavoritoSalidaDTO(
        Long id,
        Long productoId,
        String nota,
        LocalDateTime fechaAgregado
) {}