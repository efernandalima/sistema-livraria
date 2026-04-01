package com.sistema.livraria.controller;

import com.sistema.livraria.dto.request.CreateAutorRequest;
import com.sistema.livraria.dto.response.AutorResponse;
import com.sistema.livraria.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/autores")
@RequiredArgsConstructor
@Tag(name = "Autores", description = "Gerenciamento de autores")
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    @Operation(summary = "Cadastrar novo autor")
    public ResponseEntity<AutorResponse> criar(@RequestBody @Valid CreateAutorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.criar(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar autor por ID")
    public ResponseEntity<AutorResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos os autores")
    public ResponseEntity<List<AutorResponse>> listarTodos() {
        return ResponseEntity.ok(autorService.listarTodos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar autor")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}