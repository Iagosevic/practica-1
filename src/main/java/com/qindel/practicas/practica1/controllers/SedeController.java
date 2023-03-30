package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.services.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private ISedeService sedeServ;

    @GetMapping("")
    public List<SedeEntity> getSedes() {
        return sedeServ.getAllSedes();
    }

    @GetMapping("/anho/{anho}/idtipojjoo/{idtipojjoo}")
    public Optional<SedeEntity> getSedebyAnho(@PathVariable Integer anho, @PathVariable Integer idtipojjoo){
        return sedeServ.getSedeById(anho, idtipojjoo);
    }

    /*@GetMapping("/sede/{id-sede}")
    public SedeEntity getSedeByCiudad(@PathVariable("id-sede") Integer id_sede){
        return sedeRepo.findBySede(id_sede);
    }*/
}
