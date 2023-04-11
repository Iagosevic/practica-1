package com.qindel.practicas.practica1.mapper;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.TipoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ITipoMapper {
    TipoEntity toEntity(TipoDto tipoDto);
    TipoDto toDto(TipoEntity tipo);
}
