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
    @GetMapping("/anho/{anho}/idsedejjoo/{id-sede-jjoo}")
    public SedeDto getSedebyAnho(@PathVariable Integer anho, @PathVariable("id-sede-jjoo") Integer idsedejjoo){
        return sedeService.getSedeById(anho, idsedejjoo);
    }

    @PostMapping("/sede")
    public SedeDto addSede(@RequestBody SedeDto nuevaSede) {
        return sedeService.addSede(nuevaSede);
    }
    @PutMapping("/sede/anho/{anho}/idsedejjoo/{id-sede-jjoo}")
    public SedeDto updateSede(@PathVariable Integer anho, @PathVariable("id-sede-jjoo") Integer idsedejjoo, @RequestBody SedeDto nuevaSede) {
        SedeDto sedeEditar = sedeService.getSedeById(anho, idsedejjoo);

        sedeEditar.setSede(nuevaSede.getSede());
        sedeEditar.setIdtipojjoo(nuevaSede.getIdtipojjoo());
        sedeEditar.setAnho(nuevaSede.getAnho());

        return sedeService.updateSede(nuevaSede, anho, idsedejjoo);
    }

    @DeleteMapping("/sede/anho/{anho}/idsedejjoo/{id-sede-jjoo}")
    public void deleteSede(@PathVariable Integer anho, @PathVariable("id-sede-jjoo") Integer idsedejjoo) {
        sedeService.deleteSede(anho, idsedejjoo);
    }
}
