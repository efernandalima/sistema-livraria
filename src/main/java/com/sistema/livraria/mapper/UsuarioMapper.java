package com.sistema.livraria.mapper;

import com.sistema.livraria.domain.entity.Usuario;
import com.sistema.livraria.dto.request.RegisterRequest;
import com.sistema.livraria.dto.response.UsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "senha", ignore = true)
    Usuario toEntity(RegisterRequest request);

    UsuarioResponse toResponse(Usuario usuario);
}