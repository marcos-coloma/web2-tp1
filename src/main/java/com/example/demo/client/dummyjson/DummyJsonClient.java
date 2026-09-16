package com.example.demo.client.dummyjson;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class DummyJsonClient {

    private final RestClient restClient;

    public DummyJsonClient(RestClient dummyJsonRestClient) {
        this.restClient = dummyJsonRestClient;
    }

    public DummyJsonProductosResponse obtenerProductos() {
        return restClient.get()
                .uri("/products")
                .retrieve()
                .body(DummyJsonProductosResponse.class);
    }

    public DummyJsonProducto obtenerProductoPorId(Long id) {
        return restClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .body(DummyJsonProducto.class);
    }
}
