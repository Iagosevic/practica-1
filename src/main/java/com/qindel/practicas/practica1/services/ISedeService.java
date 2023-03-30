package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.entities.SedeEntity;

import java.util.List;
import java.util.Optional;

public interface ISedeService {
    public List<SedeEntity> getAllSedes();
    public Optional<SedeEntity> getSedeById(Integer anho, Integer idtipojjoo);
}
