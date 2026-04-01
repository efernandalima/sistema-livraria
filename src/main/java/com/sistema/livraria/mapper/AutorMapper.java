package com.sistema.livraria.mapper;

import com.sistema.livraria.domain.entity.Autor;
import com.sistema.livraria.dto.request.CreateAutorRequest;
import com.sistema.livraria.dto.response.AutorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AutorMapper {

    Autor toEntity(CreateAutorRequest request);

    AutorResponse toResponse(Autor autor);
}