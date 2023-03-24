package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private IPaisRepository paisRepo;

    @GetMapping("/all")
    public List<PaisEntity> getpaises(){
        return paisRepo.findAll();
    }

    @GetMapping("/{idpais}")
    public PaisEntity getpaisById(@PathVariable Integer idpais){
        return paisRepo.findByIdpais(idpais);
    }

    @GetMapping("/pais/{nombrepais}")
    public PaisEntity getpaisByNombre(@PathVariable String nombrepais){
        return paisRepo.findByNombrepais(nombrepais);
    }
}
