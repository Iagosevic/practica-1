package com.qindel.practicas.practica1.mappers;

import com.qindel.practicas.practica1.apis.SedeJJOODto;
import com.qindel.practicas.practica1.entities.SedeJJOOEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SedeJJOOMapper {
    SedeJJOOEntity toEntity (SedeJJOODto sedeJJOODto);
    SedeJJOODto toDto (SedeJJOOEntity sedeJJOO);
}
