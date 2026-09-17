package com.example.demo.controller;

import com.example.demo.dto.favorite.FavoriteInputDTO;
import com.example.demo.dto.favorite.FavoriteOutputDTO;
import com.example.demo.service.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<FavoriteOutputDTO> create(
            @RequestBody FavoriteInputDTO dto) {

        FavoriteOutputDTO favorite = favoriteService.create(dto);

        return ResponseEntity
                .created(URI.create("/api/favorites/" + favorite.id()))
                .body(favorite);
    }

    @GetMapping
    public ResponseEntity<List<FavoriteOutputDTO>> getAll() {
        return ResponseEntity.ok(favoriteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoriteOutputDTO> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(favoriteService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FavoriteOutputDTO> update(
            @PathVariable Long id,
            @RequestBody FavoriteInputDTO dto) {

        return ResponseEntity.ok(favoriteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        favoriteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}