package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.services.ISedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeController {

    @Autowired
    private ISedeService sedeService;

    @GetMapping("")
    public List<SedeDto> getSedes() {
        return sedeService.getAllSedes();
    }
    @GetMapping("/anho/{anho}/idsedejjoo/{idsedejjoo}")
    public SedeDto getSedebyAnho(@PathVariable Integer anho, @PathVariable Integer idsedejjoo){
        return sedeService.getSedeById(anho, idsedejjoo);
    }

    @PostMapping("/addSede")
    public SedeDto addSede(@RequestBody SedeDto nuevaSede) {
        return sedeService.addSede(nuevaSede);
    }
    @PutMapping("/editSede/anho/{anho}/idsedejjoo/{idsedejjoo}")
    public SedeDto updateSede(@PathVariable Integer anho, @PathVariable Integer idsedejjoo, @RequestBody SedeDto nuevaSede) {
        SedeDto sedeEditar = sedeService.getSedeById(anho, idsedejjoo);

        sedeEditar.setSede(nuevaSede.getSede());
        sedeEditar.setIdtipojjoo(nuevaSede.getIdtipojjoo());
        sedeEditar.setAnho(nuevaSede.getAnho());

        return sedeService.addSede(sedeEditar);
    }

    @DeleteMapping("/deleteSede/anho/{anho}/idsedejjoo/{idsedejjoo}")
    public void deleteSede(@PathVariable Integer anho, @PathVariable Integer idsedejjoo) {
        sedeService.deleteSede(anho, idsedejjoo);
    }
}
