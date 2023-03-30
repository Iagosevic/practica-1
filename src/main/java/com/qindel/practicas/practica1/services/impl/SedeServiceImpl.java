package com.qindel.practicas.practica1.services.impl;

import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.SedeIDEntity;
import com.qindel.practicas.practica1.repositories.ISedeRepository;
import com.qindel.practicas.practica1.services.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeServiceImpl implements ISedeService {
    @Autowired
    private ISedeRepository sedeRepo;

    @Override
    public List<SedeEntity> getAllSedes(){
        return sedeRepo.findAll();
    }
    public Optional<SedeEntity> getSedeById(Integer anho, Integer idtipojjoo){
        System.out.println("HOlaaaaaaaaaaaaaa");
        SedeIDEntity claveSede = new SedeIDEntity(anho, idtipojjoo);
        return sedeRepo.findById(claveSede);
    }
}
