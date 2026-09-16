package com.example.demo.dto.producto;

import java.util.List;

public record ProductosPaginadosDTO(
        List<ProductoDTO> productos,
        int total,
        int limit,
        int skip
) {}