package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.entities.CiudadEntity;

import java.util.List;

public interface ICiudadRepository {
    List<CiudadEntity> findByNombreCiudad(String nombre_ciudad);

}
