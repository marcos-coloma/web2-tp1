package com.example.demo.service;

import com.example.demo.client.dummyjson.DummyJsonClient;
import com.example.demo.client.dummyjson.DummyJsonProducto;
import com.example.demo.client.dummyjson.DummyJsonProductosResponse;
import com.example.demo.dto.producto.ProductoDTO;
import com.example.demo.dto.producto.ProductosPaginadosDTO;

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

    public ProductoDTO obtenerProductoPorId(Long id) {
        DummyJsonProducto producto = dummyJsonClient.obtenerProductoPorId(id);

        return mapearProducto(producto);
    }

    public ProductosPaginadosDTO obtenerProductos(int limit, int skip) {
        DummyJsonProductosResponse respuesta =
                dummyJsonClient.obtenerProductos(limit, skip);

        List<ProductoDTO> productos = respuesta.products()
                .stream()
                .map(this::mapearProducto)
                .toList();

        return new ProductosPaginadosDTO(
                productos,
                respuesta.total(),
                respuesta.limit(),
                respuesta.skip()
        );
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