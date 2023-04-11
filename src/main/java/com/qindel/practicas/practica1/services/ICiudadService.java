package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;

import java.util.List;

public interface ICiudadService {
    public List<CiudadEntity> getAllCiudades();
    public CiudadDto getCiudadByIdCiudad(Integer idciudad);
}
