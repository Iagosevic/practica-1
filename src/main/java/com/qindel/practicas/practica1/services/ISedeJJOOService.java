package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apis.*;
import com.qindel.practicas.practica1.entities.SedeJJOOWrapper;
import com.qindel.practicas.practica1.entities.TipoJJOOWrapper;

import java.util.List;

public interface ISedeJJOOService {
    public SedeJJOOWrapper getJJOOs();

    public SedeJJOODto getJJOO( Integer idAnno, Integer idTipo);

    public TipoJJOOWrapper getTipos();

    public TipoJJOODto getTipo(Integer idTipo);
}
