package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.mapper.IPaisMapper;
import com.qindel.practicas.practica1.operationtraces.PaisOperationTrace;
import com.qindel.practicas.practica1.repositories.IPaisOperationTraceRepository;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import com.qindel.practicas.practica1.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaisServiceImpl implements IPaisService {


    private IPaisRepository paisRepository;
    private IPaisOperationTraceRepository paisOTRepository;
    private IPaisMapper paisMapper;
    @Autowired
    public PaisServiceImpl(IPaisRepository paisRepository, IPaisOperationTraceRepository paisOTRepository, IPaisMapper paisMapper) {
        this.paisRepository = paisRepository;
        this.paisOTRepository = paisOTRepository;
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
        PaisOperationTrace paisOT = new PaisOperationTrace();
        paisOT.setOperation("Pais " + pais.getNombrepais()+ " añadido");
        paisOT.setTimestamp(new Date());
        paisOTRepository.save(paisOT);
        return paisMapper.toDto(paisRepository.save(paisMapper.toEntity(pais)));
    }

    @Override
    public PaisDto updatePais(PaisDto paisDto, Integer idpais) {
        PaisOperationTrace paisOT = new PaisOperationTrace();
        paisOT.setOperation("Pais "
                + paisDto.getIdpais()
                + " actualizado, valores actuales, nombre:"
                + paisDto.getNombrepais() + ", codigo:"
                + paisDto.getCodigopais() + ", valor:"
                + paisDto.getValorpais());
        paisOT.setTimestamp(new Date());
        paisOTRepository.save(paisOT);

        PaisEntity newPais = paisMapper.toEntity(paisDto);
        return paisMapper.toDto(paisRepository.findById(idpais)
                .map(pais -> {
                    pais.setIdpais(newPais.getIdpais());
                    pais.setCodigopais(newPais.getCodigopais());
                    pais.setNombrepais(newPais.getNombrepais());
                    pais.setValorpais(newPais.getValorpais());
                    return paisRepository.save(pais);
                }).orElseGet(() -> {
                    newPais.setIdpais(idpais);
                    return paisRepository.save(newPais);
                })
        );
    }
    @Override
    public void deletePais(Integer idpais) {
        PaisOperationTrace paisOT = new PaisOperationTrace();
        paisOT.setOperation("Pais " + idpais+ " eliminado");
        paisOT.setTimestamp(new Date());
        paisOTRepository.save(paisOT);
        paisRepository.deleteById(idpais);
    }
    
}
