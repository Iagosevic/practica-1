package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.mapper.ITipoMapper;
import com.qindel.practicas.practica1.repositories.ITipoRepository;
import com.qindel.practicas.practica1.services.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoServiceImpl implements ITipoService {

    private ITipoRepository tipoRepository;
    private ITipoMapper tipoMapper;
    @Autowired
    public TipoServiceImpl(ITipoRepository tipoRepository, ITipoMapper tipoMapper) {
        this.tipoRepository = tipoRepository;
        this.tipoMapper = tipoMapper;
    }

    @Override
    public List<TipoEntity> getAllTipos(){
        return tipoRepository.findAll();
    }

    @Override
    public TipoDto getTipoById(Integer idtipojjoo){
        return tipoMapper.toDto(tipoRepository.getReferenceById(idtipojjoo));
    }
    /*@Override
    public Optional<TipoEntity> getTipoById(Integer idtipojjoo){
        return tipoRepository.findById(idtipojjoo);
    }
*/}
