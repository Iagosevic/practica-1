package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;

import java.util.List;

public interface ICiudadService {
    public List<CiudadDto> getAllCiudades();
    public CiudadDto getCiudadByIdCiudad(Integer idciudad);
    public CiudadDto addCiudad(CiudadDto ciudad);
    public CiudadDto updateCiudad(CiudadDto ciudadDto, Integer idciudad);
    public void deleteCiudad(Integer idciudad);
}
