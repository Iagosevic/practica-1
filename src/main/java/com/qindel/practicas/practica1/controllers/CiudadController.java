package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    @Autowired
    private ICiudadRepository ciudadRepo;

    @GetMapping("/{nombre}")
    public List<CiudadEntity> getCiudadByNombre(@PathVariable String nombre_ciudad){
        return ciudadRepo.findByNombreCiudad(nombre_ciudad);
    }
}
