package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.entities.SedeEntity;

import java.util.List;

public interface ISedeService {
    public List<SedeDto> getAllSedes();
    public SedeDto getSedeById(Integer anho, Integer idtipojjoo);
}
