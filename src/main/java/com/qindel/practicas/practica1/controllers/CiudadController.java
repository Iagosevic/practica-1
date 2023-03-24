package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private ICiudadRepository ciudadRepo;

    @GetMapping("/all")
    public List<CiudadEntity> getCiudades(){
        return ciudadRepo.findAll();
    }

    @GetMapping("/{idciudad}")
    public CiudadEntity getCiudadById(@PathVariable Integer idciudad){
        return ciudadRepo.findByIdciudad(idciudad);
    }

    @GetMapping("/ciudad/{nombreciudad}")
    public CiudadEntity getCiudadByNombre(@PathVariable String nombreciudad){
        return ciudadRepo.findByNombreciudad(nombreciudad);
    }
}
