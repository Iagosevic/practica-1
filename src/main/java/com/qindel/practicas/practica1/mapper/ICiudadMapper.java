package com.qindel.practicas.practica1.mapper;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel="spring")
public interface ICiudadMapper {
    CiudadEntity toEntity(CiudadDto ciudadDto);
    CiudadDto toDto(CiudadEntity ciudad);
}
