package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private IPaisService paisService;
    @PreAuthorize("hasRole('USER')")
    @GetMapping("")
    public List<PaisDto> getPaises(){
        return paisService.getAllPaises();
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id-pais}")
    public PaisDto getpaisById(@PathVariable("id-pais") Integer idpais){
        return paisService.getPaisByIdPais(idpais);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/pais")
    public PaisDto addPais(@RequestBody PaisDto nuevoPais) {
        return paisService.addPais(nuevoPais);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/pais/{id-pais}")
    public PaisDto updatePais(@PathVariable("id-pais") Integer idpais, @RequestBody PaisDto nuevoPais) {
        PaisDto paisEditar = paisService.getPaisByIdPais(idpais);

        paisEditar.setNombrepais(nuevoPais.getNombrepais());
        paisEditar.setCodigopais(nuevoPais.getCodigopais());
        paisEditar.setValorpais(nuevoPais.getValorpais());

        return paisService.updatePais(nuevoPais, idpais);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/pais/{id-pais}")
    public void deletePais(@PathVariable("id-pais") Integer idpais) {
        paisService.deletePais(idpais);
    }
}
