package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import com.qindel.practicas.practica1.repositories.ISedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private ISedeRepository sedeRepo;

    @GetMapping("/all")
    public List<SedeEntity> getSedes(){
        return sedeRepo.findAll();
    }

    @GetMapping("/{anho}")
    public List<SedeEntity> getSedebyAnho(@PathVariable Integer anho){
        return sedeRepo.findByAnho(anho);
    }

    @GetMapping("/sede/{id_sede}")
    public SedeEntity getSedeByCiudad(@PathVariable Integer id_sede){
        return sedeRepo.findBySede(id_sede);
    }
}
