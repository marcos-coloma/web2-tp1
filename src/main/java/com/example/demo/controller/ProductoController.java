package com.example.demo.controller;

import com.example.demo.dto.producto.ProductoDTO;
import com.example.demo.dto.producto.ProductosPaginadosDTO;
import com.example.demo.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ProductosPaginadosDTO obtenerProductos(
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "0") int skip) {

        return productoService.obtenerProductos(limit, skip);
    }

    @GetMapping("/{id}")
    public ProductoDTO obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }
}