package com.example.demo.dto.producto;

public record ProductoDTO(
        Long id,
        String nombre,
        String descripcion,
        String categoria,
        double precio,
        int stock,
        String imagen
) {}