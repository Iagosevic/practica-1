package com.qindel.practicas.practica1.mapper;

import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.entities.SedeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ISedeMapper {
    SedeEntity toEntity(SedeDto sedeDto);
    SedeDto toDto(SedeEntity sede);
}
