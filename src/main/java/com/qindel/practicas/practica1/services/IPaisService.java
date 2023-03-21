package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apis.*;
import com.qindel.practicas.practica1.entities.CiudadWrapper;
import com.qindel.practicas.practica1.entities.PaisWrapper;

import java.util.List;

public interface IPaisService {
    public CiudadWrapper getCiudades();

    public CiudadDto getCiudad(Integer idCiudad);

    public PaisWrapper getPaises();

    public PaisDto getPais(Integer idPais);
}
