package com.qindel.practicas.practica1.mappers;

import com.qindel.practicas.practica1.apis.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper {
    PaisEntity toEntity(PaisDto paisDto);
    PaisDto toDto(PaisEntity pais);
}
