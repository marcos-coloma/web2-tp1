package com.example.demo.service;

import com.example.demo.client.dummyjson.DummyJsonClient;
import com.example.demo.client.dummyjson.DummyJsonProducto;
import com.example.demo.dto.producto.ProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final DummyJsonClient dummyJsonClient;

    public ProductoService(DummyJsonClient dummyJsonClient) {
        this.dummyJsonClient = dummyJsonClient;
    }

    public List<ProductoDTO> obtenerProductos() {
        return dummyJsonClient.obtenerProductos()
                .products()
                .stream()
                .map(this::mapearProducto)
                .toList();
    }

    private ProductoDTO mapearProducto(DummyJsonProducto producto) {
        return new ProductoDTO(
                producto.id(),
                producto.title(),
                producto.description(),
                producto.category(),
                producto.price(),
                producto.stock(),
                producto.thumbnail()
        );
    }
}