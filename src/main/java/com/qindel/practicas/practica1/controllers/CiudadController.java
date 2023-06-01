package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.services.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private ICiudadService ciudadService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("")
    public List<CiudadDto> getCiudades(){
        return  ciudadService.getAllCiudades();
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id-ciudad}")
    public CiudadDto getCiudadByIdCiudad(@PathVariable("id-ciudad") Integer idciudad){
        return ciudadService.getCiudadByIdCiudad(idciudad);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/ciudad")
    public CiudadDto addCiudad(@RequestBody CiudadDto nuevaCiudad) {
        return ciudadService.addCiudad(nuevaCiudad);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/ciudad/{id-ciudad}")
    public CiudadDto updateCiudad(@PathVariable("id-ciudad") Integer idciudad, @RequestBody CiudadDto nuevaCiudad) {
        CiudadDto ciudadEditar = ciudadService.getCiudadByIdCiudad(idciudad);

        ciudadEditar.setNombreciudad(nuevaCiudad.getNombreciudad());
        ciudadEditar.setIdpais(nuevaCiudad.getIdpais());
        ciudadEditar.setValorciudad(nuevaCiudad.getValorciudad());

        return ciudadService.updateCiudad(nuevaCiudad, idciudad);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/ciudad/{id-ciudad}")
    public void deleteCiudad(@PathVariable("id-ciudad") Integer idciudad) {
        ciudadService.deleteCiudad(idciudad);
    }

}
