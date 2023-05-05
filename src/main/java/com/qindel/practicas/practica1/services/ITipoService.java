package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.TipoEntity;

import java.util.List;

public interface ITipoService {
    public List<TipoDto> getAllTipos();
    public TipoDto getTipoById(Integer idtipojjoo);
    public TipoDto addTipo(TipoDto tipo);
    public TipoDto updateTipo(TipoDto tipoJJOODto, Integer id_tipo_jjoo);
    public void deleteTipo(Integer id_tipo_jjoo);
}
