package com.example.demo.client.dummyjson;

import com.example.demo.exception.ResourceNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Component
public class DummyJsonClient {

    private final RestClient restClient;

    public DummyJsonClient(RestClient dummyJsonRestClient) {
        this.restClient = dummyJsonRestClient;
    }

    public DummyJsonProductsResponse getProducts() {
        return restClient.get()
                .uri("/products")
                .retrieve()
                .body(DummyJsonProductsResponse.class);
    }

    public DummyJsonProduct getProductById(Long id) {
        try {
            return restClient.get()
                    .uri("/products/{id}", id)
                    .retrieve()
                    .body(DummyJsonProduct.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new ResourceNotFoundException(
                    "Product not found with id: " + id);
        }
    }

    public DummyJsonProductsResponse getProducts(int limit, int skip) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/products")
                        .queryParam("limit", limit)
                        .queryParam("skip", skip)
                        .build())
                .retrieve()
                .body(DummyJsonProductsResponse.class);
    }
}