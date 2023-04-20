package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.SedeIDEntity;
import com.qindel.practicas.practica1.mapper.ISedeMapper;
import com.qindel.practicas.practica1.repositories.ISedeRepository;
import com.qindel.practicas.practica1.services.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SedeServiceImpl implements ISedeService {

    private ISedeRepository sedeRepository;
    private ISedeMapper sedeMapper;
    @Autowired
    public SedeServiceImpl(ISedeRepository sedeRepository, ISedeMapper sedeMapper) {
        this.sedeRepository = sedeRepository;
        this.sedeMapper = sedeMapper;
    }

    @Override
    public List<SedeDto> getAllSedes(){
        List<SedeEntity> sedesEntity = new ArrayList<SedeEntity>();
        List<SedeDto> sedesDto = new ArrayList<SedeDto>();
        sedeRepository.findAll().forEach(sedesEntity::add);
        for (int i = 0; i < sedesEntity.size(); i++){
            sedesDto.add(sedeMapper.toDto(sedesEntity.get(i)));
        }
        return sedesDto;
    }
    @Override
    public SedeDto getSedeById(Integer anho, Integer idtipojjoo){
        SedeIDEntity claveSede = new SedeIDEntity(anho, idtipojjoo);
        return sedeMapper.toDto(sedeRepository.getReferenceById(claveSede));
    }
}
