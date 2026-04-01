package com.sistema.livraria.mapper;

import com.sistema.livraria.domain.entity.Emprestimo;
import com.sistema.livraria.dto.response.EmprestimoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmprestimoMapper {

    @Mapping(source = "livro.titulo", target = "tituloLivro")
    @Mapping(source = "usuario.nome", target = "nomeUsuario")
    EmprestimoResponse toResponse(Emprestimo emprestimo);
}