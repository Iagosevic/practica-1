package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.mapper.IPaisMapper;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import com.qindel.practicas.practica1.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<PaisDto> getAllPaises(){
        List<PaisEntity> paisesEntity = new ArrayList<PaisEntity>();
        List<PaisDto> paisesDto = new ArrayList<PaisDto>();
        paisRepository.findAll().forEach(paisesEntity::add);
        for (int i = 0; i < paisesEntity.size(); i++){
            paisesDto.add(paisMapper.toDto(paisesEntity.get(i)));
        }
        return paisesDto;
    }

    @Override
    public PaisDto getPaisByIdPais(Integer idpais) {
        return paisMapper.toDto(paisRepository.getReferenceById(idpais));
    }

    @Override
    public PaisDto addPais(PaisDto pais) {
        return paisMapper.toDto(paisRepository.save(paisMapper.toEntity(pais)));
    }

    @Override
    public PaisDto updatePais(PaisDto paisDto, Integer idpais) {
        PaisEntity newPais = paisMapper.toEntity(paisDto);
        return paisMapper.toDto(paisRepository.findById(idpais)
                .map(pais -> {
                    pais.setNombrepais(newPais.getNombrepais());
                    pais.setCodigopais(newPais.getCodigopais());
                    pais.setValorpais(newPais.getValorpais());
                    return paisRepository.save(pais);
                }).orElseGet(() -> paisRepository.save(newPais))
        );
    }
    @Override
    public void deletePais(Integer idpais) {
        paisRepository.deleteById(idpais);
    }
    
}
