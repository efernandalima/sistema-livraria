package com.sistema.livraria.mapper;

import com.sistema.livraria.domain.entity.Livro;
import com.sistema.livraria.dto.request.CreateLivroRequest;
import com.sistema.livraria.dto.response.LivroResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LivroMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "autor", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Livro toEntity(CreateLivroRequest request);

    @Mapping(source = "autor.nome", target = "autorNome")
    LivroResponse toResponse(Livro livro);
}