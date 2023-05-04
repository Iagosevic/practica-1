package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;

import java.util.List;

public interface IPaisService {
    public List<PaisDto> getAllPaises();
    public PaisDto getPaisByIdPais(Integer idpais);
    public PaisDto addPais(PaisDto paisDto);
}
