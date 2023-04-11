package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import com.qindel.practicas.practica1.services.ICiudadService;
import com.qindel.practicas.practica1.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private IPaisService paisService;

    @GetMapping("")
    public List<PaisEntity> getPaises(){
        return paisService.getAllPaises();
    }
    @GetMapping("/{id-pais}")
    public PaisDto getpaisById(@PathVariable("id-pais") Integer idpais){
        return paisService.getPaisByIdPais(idpais);
    }

    /*@GetMapping("/{id-pais}")
    public Optional<PaisEntity> getpaisById(@PathVariable("id-pais") Integer idpais){
        return paisServ.getPaisByIdPais(idpais);
    }*/

 /*   @GetMapping("/pais/{nombre-pais}")
    public PaisEntity getpaisByNombre(@PathVariable String nombrepais){
        return paisRepo.findByNombrepais(nombrepais);
    }*/
}
