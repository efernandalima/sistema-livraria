package com.sistema.livraria.controller;

import com.sistema.livraria.dto.request.CreateEmprestimoRequest;
import com.sistema.livraria.dto.response.EmprestimoResponse;
import com.sistema.livraria.service.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
@RequiredArgsConstructor
@Tag(name = "Empréstimos", description = "Gerenciamento de empréstimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping("/usuario/{usuarioId}")
    @Operation(summary = "Realizar empréstimo")
    public ResponseEntity<EmprestimoResponse> realizar(
            @RequestBody @Valid CreateEmprestimoRequest request,
            @PathVariable Long usuarioId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(emprestimoService.realizar(request, usuarioId));
    }

    @PatchMapping("/{id}/devolver/usuario/{usuarioId}")
    @Operation(summary = "Devolver livro")
    public ResponseEntity<EmprestimoResponse> devolver(
            @PathVariable Long id,
            @PathVariable Long usuarioId) {
        return ResponseEntity.ok(emprestimoService.devolver(id, usuarioId));
    }

    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Listar empréstimos por usuário")
    public ResponseEntity<List<EmprestimoResponse>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(emprestimoService.listarPorUsuario(usuarioId));
    }

    @GetMapping("/atrasados")
    @Operation(summary = "Listar empréstimos atrasados")
    public ResponseEntity<List<EmprestimoResponse>> listarAtrasados() {
        return ResponseEntity.ok(emprestimoService.listarAtrasados());
    }
}