package com.qindel.practicas.practica1.mappers;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.entities.PaisEntity;
import org.mapstruct.Mapper;
        @Mapper(componentModel="spring")
        public interface IPaisMapper {
        PaisEntity toEntity(PaisDto paisDto);
        PaisDto toDto(PaisEntity pais);
        }
