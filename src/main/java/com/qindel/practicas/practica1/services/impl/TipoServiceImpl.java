package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.mapper.ITipoMapper;
import com.qindel.practicas.practica1.operationtraces.TipoOperationTrace;
import com.qindel.practicas.practica1.repositories.ITipoOperationTraceRepository;
import com.qindel.practicas.practica1.repositories.ITipoRepository;
import com.qindel.practicas.practica1.services.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TipoServiceImpl implements ITipoService {

    private ITipoRepository tipoRepository;
    private ITipoOperationTraceRepository tipoOTRepository;
    private ITipoMapper tipoMapper;
    @Autowired
    public TipoServiceImpl(ITipoRepository tipoRepository, ITipoOperationTraceRepository tipoOTRepository, ITipoMapper tipoMapper) {
        this.tipoRepository = tipoRepository;
        this.tipoOTRepository = tipoOTRepository;
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
        TipoOperationTrace tipoOT = new TipoOperationTrace();
        tipoOT.setOperation("Tipo " + tipo.getDescripciontipo()+ " añadido");
        tipoOT.setTimestamp(new Date());
        tipoOTRepository.save(tipoOT);

        return tipoMapper.toDto(tipoRepository.save(tipoMapper.toEntity(tipo)));
    }

    public TipoDto updateTipo(TipoDto tipoDto, Integer id_tipo_jjoo) {
        TipoOperationTrace tipoOT = new TipoOperationTrace();
        tipoOT.setOperation("Tipo "
                + id_tipo_jjoo
                + " actualizado, valores actuales, nombre:"
                + tipoDto.getDescripciontipo());
        tipoOT.setTimestamp(new Date());
        tipoOTRepository.save(tipoOT);

        TipoEntity newTipoJJOO = tipoMapper.toEntity(tipoDto);
        return tipoMapper.toDto(tipoRepository.findById(id_tipo_jjoo)
                .map(tipo -> {
                    tipo.setDescripciontipo(newTipoJJOO.getDescripciontipo());
                    return tipoRepository.save(tipo);
                }).orElseGet(() -> tipoRepository.save(newTipoJJOO))
        );
    }

    @Override
    public void deleteTipo(Integer idTipo) {
        TipoOperationTrace tipoOT = new TipoOperationTrace();
        tipoOT.setOperation("Tipo " + idTipo+ " eliminado");
        tipoOT.setTimestamp(new Date());
        tipoOTRepository.save(tipoOT);

        tipoRepository.deleteById(idTipo);
    }
}
