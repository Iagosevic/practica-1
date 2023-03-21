package com.qindel.practicas.practica1.mappers;

import com.qindel.practicas.practica1.apis.TipoJJOODto;
import com.qindel.practicas.practica1.entities.TipoJJOOEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoJJOOMapper {
    TipoJJOOEntity toEntity (TipoJJOODto tipoJJOODto);
    TipoJJOODto toDto (TipoJJOOEntity tipoJJOO);
}
