package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.entities.PaisEntity;

import java.util.List;
import java.util.Optional;

public interface IPaisService {
    public List<PaisEntity> getAllPaises();
    public Optional<PaisEntity> getPaisByIdPais(Integer idciudad);
}
