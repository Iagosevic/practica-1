package com.qindel.practicas.practica1.services.impl;


import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.SedeIDEntity;
import com.qindel.practicas.practica1.mapper.ISedeMapper;
import com.qindel.practicas.practica1.operationtraces.SedeOperationTrace;
import com.qindel.practicas.practica1.repositories.ISedeOperationTraceRepository;
import com.qindel.practicas.practica1.repositories.ISedeRepository;
import com.qindel.practicas.practica1.services.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SedeServiceImpl implements ISedeService {

    private ISedeRepository sedeRepository;
    private ISedeOperationTraceRepository sedeOTRepository;
    private ISedeMapper sedeMapper;
    @Autowired
    public SedeServiceImpl(ISedeRepository sedeRepository,ISedeOperationTraceRepository sedeOTRepository, ISedeMapper sedeMapper) {
        this.sedeRepository = sedeRepository;
        this.sedeOTRepository = sedeOTRepository;
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

    @Override
    public SedeDto addSede(SedeDto sede) {
        SedeOperationTrace sedeOT = new SedeOperationTrace();
        sedeOT.setOperation("Sede " + sede.getSede()+ " añadida");
        sedeOT.setTimestamp(new Date());
        sedeOTRepository.save(sedeOT);
        return sedeMapper.toDto(sedeRepository.save(sedeMapper.toEntity(sede)));
    }
    @Override
    public SedeDto updateSede(SedeDto sedeDto, Integer anno, Integer id_tipo_jjoo) {
        SedeOperationTrace sedeOT = new SedeOperationTrace();
        sedeOT.setOperation("Se ha actualizado la sede "
                + sedeDto.getIdtipojjoo()
                + ", valores actuales, anno:"
                + sedeDto.getAnho() + ", sede:"
                + sedeDto.getSede());
        sedeOT.setTimestamp(new Date());
        sedeOTRepository.save(sedeOT);

        SedeIDEntity sedeJJOOId = new SedeIDEntity(anno, id_tipo_jjoo);
        SedeEntity newSedeJJOO = sedeMapper.toEntity(sedeDto);
        return sedeMapper.toDto(sedeRepository.findById(sedeJJOOId)
                .map(sede -> {
                    sede.setAnho(newSedeJJOO.getAnho());
                    sede.setIdtipojjoo(newSedeJJOO.getIdtipojjoo());
                    sede.setSede(newSedeJJOO.getSede());
                    return sedeRepository.save(sede);
                }).orElseGet(() -> {
                    newSedeJJOO.setAnho(anno);
                    newSedeJJOO.setIdtipojjoo(id_tipo_jjoo);
                    return sedeRepository.save(newSedeJJOO);
                })
        );
    }
    @Override
    public void deleteSede(Integer anno, Integer id_tipo_jjoo){
        SedeOperationTrace sedeOT = new SedeOperationTrace();
        sedeOT.setOperation("Sede del tipo" + id_tipo_jjoo+" y del año " + anno );
        sedeOT.setTimestamp(new Date());
        sedeOTRepository.save(sedeOT);

        SedeIDEntity sedeJJOOId = new SedeIDEntity(anno, id_tipo_jjoo);
        sedeRepository.deleteById(sedeJJOOId);
    }
}
