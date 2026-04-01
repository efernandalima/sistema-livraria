package com.sistema.livraria.controller;

import com.sistema.livraria.dto.request.CreateLivroRequest;
import com.sistema.livraria.dto.response.LivroResponse;
import com.sistema.livraria.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
@Tag(name = "Livros", description = "Gerenciamento de livros")
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    @Operation(summary = "Cadastrar novo livro")
    public ResponseEntity<LivroResponse> criar(@RequestBody @Valid CreateLivroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.criar(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar livro por ID")
    public ResponseEntity<LivroResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos os livros")
    public ResponseEntity<List<LivroResponse>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @GetMapping("/disponiveis")
    @Operation(summary = "Listar livros disponíveis")
    public ResponseEntity<List<LivroResponse>> listarDisponiveis() {
        return ResponseEntity.ok(livroService.listarDisponiveis());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar livro")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}