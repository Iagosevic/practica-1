package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.mapper.ICiudadMapper;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.services.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImpl implements ICiudadService {

    private ICiudadRepository ciudadRepository;
    private ICiudadMapper ciudadMapper;
    @Autowired
    public CiudadServiceImpl(ICiudadRepository ciudadRepository, ICiudadMapper ciudadMapper) {
        this.ciudadRepository = ciudadRepository;
        this.ciudadMapper = ciudadMapper;
    }

    @Override
    public List<CiudadDto> getAllCiudades(){
        List<CiudadEntity> ciudadesEntity = new ArrayList<CiudadEntity>();
        List<CiudadDto> ciudadesDto = new ArrayList<CiudadDto>();
        ciudadRepository.findAll().forEach(ciudadesEntity::add);
        for (int i = 0; i < ciudadesEntity.size(); i++){
            ciudadesDto.add(ciudadMapper.toDto(ciudadesEntity.get(i)));
        }
        return ciudadesDto;
    }
    @Override
    public CiudadDto getCiudadByIdCiudad(Integer idciudad) {
        return ciudadMapper.toDto(ciudadRepository.getReferenceById(idciudad));
    }

    @Override
    public CiudadDto addCiudad(CiudadDto ciudad) {
        return ciudadMapper.toDto(ciudadRepository.save(ciudadMapper.toEntity(ciudad)));
    }
}
