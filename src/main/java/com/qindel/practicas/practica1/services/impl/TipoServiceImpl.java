package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.repositories.ITipoRepository;
import com.qindel.practicas.practica1.services.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoServiceImpl implements ITipoService {
    @Autowired
    private ITipoRepository tipoRepo;

    @Override
    public List<TipoEntity> getAllTipos(){
        return tipoRepo.findAll();
    }
    @Override
    public Optional<TipoEntity> getTipoById(Integer idtipojjoo){
        return tipoRepo.findById(idtipojjoo);
    }
}
