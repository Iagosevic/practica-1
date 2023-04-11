package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;

import java.util.List;

public interface IPaisService {
    public List<PaisEntity> getAllPaises();
    public PaisDto getPaisByIdPais(Integer idpais);
}
