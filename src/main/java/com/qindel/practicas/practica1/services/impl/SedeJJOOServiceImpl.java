package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apis.SedeJJOODto;
import com.qindel.practicas.practica1.apis.TipoJJOODto;
import com.qindel.practicas.practica1.entities.*;
import com.qindel.practicas.practica1.mappers.SedeJJOOMapper;
import com.qindel.practicas.practica1.mappers.TipoJJOOMapper;
import com.qindel.practicas.practica1.repositories.ISedeJJOORepository;
import com.qindel.practicas.practica1.repositories.ITipoJJOORepository;
import com.qindel.practicas.practica1.services.ISedeJJOOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SedeJJOOServiceImpl implements ISedeJJOOService {

    private ISedeJJOORepository sedeRepository;
    private ITipoJJOORepository tipoRepository;
    private SedeJJOOMapper sedeJJOOMapper;
    private TipoJJOOMapper tipoJJOOMapper;

    @Autowired
    public SedeJJOOServiceImpl(ISedeJJOORepository sedeRepository,ITipoJJOORepository tipoRepository,
                           SedeJJOOMapper sedeJJOOMapper,
                           TipoJJOOMapper tipoJJOOMapper) {
        this.sedeRepository = sedeRepository;
        this.tipoRepository = tipoRepository;
        this.sedeJJOOMapper= sedeJJOOMapper;
        this.tipoJJOOMapper = tipoJJOOMapper;
    }

    public SedeJJOOWrapper getJJOOs() {
        SedeJJOOWrapper swrapper = new SedeJJOOWrapper();
        List<SedeJJOOEntity> sedes = new ArrayList<SedeJJOOEntity>();
        sedeRepository.findAll().forEach(sedes::add);
        swrapper.setSedes(sedes);
        return swrapper;
    }

    public SedeJJOODto getJJOO(Integer idAnno, Integer idTipo) {
        return sedeJJOOMapper.toDto(sedeRepository.getReferenceById(new SedeJJOOPKEntity(idAnno,idTipo)));
    }

    public TipoJJOOWrapper getTipos() {
        TipoJJOOWrapper twrapper = new TipoJJOOWrapper();
        List<TipoJJOOEntity> tipos = new ArrayList<TipoJJOOEntity>();
        tipoRepository.findAll().forEach(tipos::add);
        twrapper.setTipos(tipos);
        return twrapper;
    }

    public TipoJJOODto getTipo(Integer idTipo) {
        return tipoJJOOMapper.toDto(tipoRepository.getReferenceById(idTipo));
    }
}
