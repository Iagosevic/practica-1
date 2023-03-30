package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.entities.TipoEntity;

import java.util.List;
import java.util.Optional;

public interface ITipoService {
    public List<TipoEntity> getAllTipos();
    public Optional<TipoEntity> getTipoById(Integer idtipojjoo);
}
