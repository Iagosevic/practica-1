package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.entities.SedeEntity;

import java.util.List;

public interface ISedeService {
    public List<SedeDto> getAllSedes();
    public SedeDto getSedeById(Integer anho, Integer idtipojjoo);
    public SedeDto addSede(SedeDto sede);
    public SedeDto updateSede(SedeDto sedeJJOODto, Integer anno, Integer id_tipo_jjoo);
}
