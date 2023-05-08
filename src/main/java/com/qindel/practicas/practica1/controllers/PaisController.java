package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private IPaisService paisService;

    @GetMapping("")
    public List<PaisDto> getPaises(){
        return paisService.getAllPaises();
    }
    @GetMapping("/{id-pais}")
    public PaisDto getpaisById(@PathVariable("id-pais") Integer idpais){
        return paisService.getPaisByIdPais(idpais);
    }
    @PostMapping("/addPais")
    public PaisDto addPais(@RequestBody PaisDto nuevoPais) {
        return paisService.addPais(nuevoPais);
    }
    @PutMapping("/editPais/{idpais}")
    public PaisDto updatePais(@PathVariable Integer idpais, @RequestBody PaisDto nuevoPais) {
        PaisDto paisEditar = paisService.getPaisByIdPais(idpais);

        paisEditar.setNombrepais(nuevoPais.getNombrepais());
        paisEditar.setCodigopais(nuevoPais.getCodigopais());
        paisEditar.setValorpais(nuevoPais.getValorpais());

        return paisService.addPais(paisEditar);

    }

    @DeleteMapping("/deletePais/{idpais}")
    public void deletePais(@PathVariable Integer idpais) {
        paisService.deletePais(idpais);
    }
}
