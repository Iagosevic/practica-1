package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.mapper.ITipoMapper;
import com.qindel.practicas.practica1.repositories.ITipoRepository;
import com.qindel.practicas.practica1.services.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoServiceImpl implements ITipoService {

    private ITipoRepository tipoRepository;
    private ITipoMapper tipoMapper;
    @Autowired
    public TipoServiceImpl(ITipoRepository tipoRepository, ITipoMapper tipoMapper) {
        this.tipoRepository = tipoRepository;
        this.tipoMapper = tipoMapper;
    }

    @Override
    public List<TipoDto> getAllTipos(){
        List<TipoEntity> tiposEntity = new ArrayList<TipoEntity>();
        List<TipoDto> tiposDto = new ArrayList<TipoDto>();
        tipoRepository.findAll().forEach(tiposEntity::add);
        for (int i = 0; i < tiposEntity.size(); i++){
            tiposDto.add(tipoMapper.toDto(tiposEntity.get(i)));
        }
        return tiposDto;
    }

    @Override
    public TipoDto getTipoById(Integer idtipojjoo){
        return tipoMapper.toDto(tipoRepository.getReferenceById(idtipojjoo));
    }

    @Override
    public TipoDto addTipo(TipoDto tipo) {
        return tipoMapper.toDto(tipoRepository.save(tipoMapper.toEntity(tipo)));
    }

    public TipoDto updateTipo(TipoDto tipoJJOODto, Integer id_tipo_jjoo) {
        TipoEntity newTipoJJOO = tipoMapper.toEntity(tipoJJOODto);
        return tipoMapper.toDto(tipoRepository.findById(id_tipo_jjoo)
                .map(tipo -> {
                    tipo.setIdtipojjoo(newTipoJJOO.getIdtipojjoo());
                    tipo.setDescripciontipo(newTipoJJOO.getDescripciontipo());
                    return tipoRepository.save(tipo);
                }).orElseGet(() -> {
                    newTipoJJOO.setIdtipojjoo(id_tipo_jjoo);
                    return tipoRepository.save(newTipoJJOO);
                })
        );
    }
}
