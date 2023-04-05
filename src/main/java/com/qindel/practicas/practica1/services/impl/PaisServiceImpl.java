package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.mappers.IPaisMapper;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import com.qindel.practicas.practica1.services.ICiudadService;
import com.qindel.practicas.practica1.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements IPaisService {

    private IPaisRepository paisRepo;
    private IPaisMapper paisMap;

    public PaisServiceImpl(IPaisRepository paisRepo, IPaisMapper paisMap) {
        this.paisRepo = paisRepo;
        this.paisMap = paisMap;
    }

    @Override
    public List<PaisEntity> getAllPaises(){
        return paisRepo.findAll();
    }

    @Override
    public PaisDto getPais(Integer idpais) {
        return paisMap.toDto(paisRepo.getReferenceById(idpais));
    }

    @Override
    public Optional<PaisEntity> getPaisByIdPais(Integer idpais){
        return paisRepo.findById(idpais);
    }
}
