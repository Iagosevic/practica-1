package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.mapper.ICiudadMapper;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.services.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<CiudadEntity> getAllCiudades(){
        return ciudadRepository.findAll();
    }
    @Override
    public CiudadDto getCiudadByIdCiudad(Integer idciudad) {
        return ciudadMapper.toDto(ciudadRepository.getReferenceById(idciudad));
    }

   /* @Override
    public Optional<CiudadEntity> getCiudadByIdCiudad(Integer idciudad){
        return ciudadRepo.findById(idciudad);
    }
*/
}
