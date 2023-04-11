package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.mapper.IPaisMapper;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import com.qindel.practicas.practica1.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements IPaisService {


    private IPaisRepository paisRepository;
    private IPaisMapper paisMapper;
    @Autowired
    public PaisServiceImpl(IPaisRepository paisRepository, IPaisMapper paisMapper) {
        this.paisRepository = paisRepository;
        this.paisMapper = paisMapper;
    }

    @Override
    public List<PaisEntity> getAllPaises(){
        return paisRepository.findAll();
    }

    @Override
    public PaisDto getPaisByIdPais(Integer idpais) {
        return paisMapper.toDto(paisRepository.getReferenceById(idpais));
    }
}
