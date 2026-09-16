package com.example.demo.controller;

import com.example.demo.dto.favorito.FavoritoEntradaDTO;
import com.example.demo.dto.favorito.FavoritoSalidaDTO;
import com.example.demo.service.FavoritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    private final FavoritoService favoritoService;

    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    @PostMapping
    public ResponseEntity<FavoritoSalidaDTO> crear(
            @RequestBody FavoritoEntradaDTO dto) {

        FavoritoSalidaDTO favorito = favoritoService.crear(dto);

        return ResponseEntity
                .created(URI.create("/api/favoritos/" + favorito.id()))
                .body(favorito);
    }

    @GetMapping
    public ResponseEntity<List<FavoritoSalidaDTO>> obtenerTodos() {
        return ResponseEntity.ok(favoritoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoritoSalidaDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(favoritoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FavoritoSalidaDTO> actualizar(
            @PathVariable Long id,
            @RequestBody FavoritoEntradaDTO dto) {

        return ResponseEntity.ok(favoritoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {

        favoritoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}