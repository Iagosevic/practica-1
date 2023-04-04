package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;

import java.util.List;
import java.util.Optional;

public interface ICiudadService {
    public List<CiudadEntity> getAllCiudades();
    public Optional<CiudadEntity> getCiudadByIdCiudad(Integer idciudad);

    public CiudadDto getCiudad(Integer idciudad);
}
