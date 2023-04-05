package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.mappers.ICiudadMapper;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.services.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadServiceImpl implements ICiudadService {
    private ICiudadRepository ciudadRepo;
    private ICiudadMapper ciudadMap;

    public CiudadServiceImpl(ICiudadRepository ciudadRepo, ICiudadMapper ciudadMap) {
        this.ciudadRepo = ciudadRepo;
        this.ciudadMap = ciudadMap;
    }

    @Override
    public List<CiudadEntity> getAllCiudades(){
        return ciudadRepo.findAll();
    }
    @Override
    public CiudadDto getCiudad(Integer idciudad) {
        return ciudadMap.toDto(ciudadRepo.getReferenceById(idciudad));
    }

    @Override
    public Optional<CiudadEntity> getCiudadByIdCiudad(Integer idciudad){
        return ciudadRepo.findById(idciudad);
    }
}
