package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apis.CiudadDto;
import com.qindel.practicas.practica1.apis.PaisDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.entities.CiudadWrapper;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.entities.PaisWrapper;
import com.qindel.practicas.practica1.mappers.CiudadMapper;
import com.qindel.practicas.practica1.mappers.PaisMapper;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import com.qindel.practicas.practica1.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PaisServiceImpl implements IPaisService{

    private ICiudadRepository ciudadRepository;
    private IPaisRepository paisRepository;
    private CiudadMapper ciudadMapper;
    private PaisMapper paisMapper;

    @Autowired
    public PaisServiceImpl(ICiudadRepository ciudadRepository, IPaisRepository paisRepository, CiudadMapper ciudadMapper, PaisMapper paisMapper) {
        this.ciudadRepository = ciudadRepository;
        this.paisRepository = paisRepository;
        this.ciudadMapper = ciudadMapper;
        this.paisMapper = paisMapper;
    }

    public CiudadWrapper getCiudades() {
        CiudadWrapper cwrapper = new CiudadWrapper();
        List<CiudadEntity> ciudades = new ArrayList<CiudadEntity>();
        ciudadRepository.findAll().forEach(ciudades::add);
        cwrapper.setCiudades(ciudades);
        return cwrapper;
    }

    public CiudadDto getCiudad(Integer idCiudad) {
        return ciudadMapper.toDto(ciudadRepository.getReferenceById(idCiudad));
    }

    public PaisWrapper getPaises() {
        PaisWrapper pwrapper = new PaisWrapper();
        List<PaisEntity> paises = new ArrayList<PaisEntity>();
        paisRepository.findAll().forEach(paises::add);
        pwrapper.setPaises(paises);
        return pwrapper;
    }

    public PaisDto getPais(Integer idPais) {
        return paisMapper.toDto(paisRepository.getReferenceById(idPais));
    }

}
