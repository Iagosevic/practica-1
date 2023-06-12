package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.mapper.ICiudadMapper;
import com.qindel.practicas.practica1.operationtraces.CiudadOperationTrace;
import com.qindel.practicas.practica1.repositories.ICiudadOperationTraceRepository;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.services.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CiudadServiceImpl implements ICiudadService {

    private ICiudadRepository ciudadRepository;

    private ICiudadOperationTraceRepository ciudadOTRepository;
    private ICiudadMapper ciudadMapper;
    @Autowired
    public CiudadServiceImpl(ICiudadRepository ciudadRepository, ICiudadOperationTraceRepository ciudadOTRepository, ICiudadMapper ciudadMapper) {
        this.ciudadRepository = ciudadRepository;
        this.ciudadOTRepository = ciudadOTRepository;
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
        CiudadOperationTrace ciudadOT = new CiudadOperationTrace();
        ciudadOT.setOperation("Ciudad " + ciudad.getNombreciudad()+ " añadida");
        ciudadOT.setTimestamp(new Date());
        ciudadOTRepository.save(ciudadOT);
        
        return ciudadMapper.toDto(ciudadRepository.save(ciudadMapper.toEntity(ciudad)));
    }
    @Override
    public CiudadDto updateCiudad(CiudadDto ciudadDto, Integer idciudad) {
        CiudadOperationTrace ciudadOT = new CiudadOperationTrace();
        ciudadOT.setOperation("Ciudad "
                + idciudad
                + " actualizada, valores actuales, nombre:"
                + ciudadDto.getNombreciudad() + ", pais:"
                + ciudadDto.getIdpais() + ", valor:"
                + ciudadDto.getValorciudad());
        ciudadOT.setTimestamp(new Date());
        ciudadOTRepository.save(ciudadOT);

        CiudadEntity newCiudad = ciudadMapper.toEntity(ciudadDto);
        return ciudadMapper.toDto(ciudadRepository.findById(idciudad)
                .map(ciudad -> {
                    ciudad.setIdpais(newCiudad.getIdpais());
                    ciudad.setNombreciudad(newCiudad.getNombreciudad());
                    ciudad.setValorciudad(newCiudad.getValorciudad());
                    return ciudadRepository.save(ciudad);
                }).orElseGet(() -> ciudadRepository.save(newCiudad))
        );
    }
    @Override
    public void deleteCiudad(Integer idciudad) {
        CiudadOperationTrace ciudadOT = new CiudadOperationTrace();
        ciudadOT.setOperation("Ciudad " + idciudad+ " eliminada");
        ciudadOT.setTimestamp(new Date());
        ciudadOTRepository.save(ciudadOT);

        ciudadRepository.deleteById(idciudad);
    }
}
