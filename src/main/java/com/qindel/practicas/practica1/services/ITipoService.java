package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.TipoEntity;

import java.util.List;

public interface ITipoService {
    public List<TipoEntity> getAllTipos();
    public TipoDto getTipoById(Integer idtipojjoo);
}
