package com.qindel.practicas.practica1.mappers;

import com.qindel.practicas.practica1.apis.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface CiudadMapper {
    CiudadEntity toEntity(CiudadDto ciudadDto);
    CiudadDto toDto(CiudadEntity ciudad);
}
