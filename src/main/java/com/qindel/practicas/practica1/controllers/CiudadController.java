package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.services.ICiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private ICiudadService ciudadService;

    @GetMapping("")
    public List<CiudadDto> getCiudades(){
        return  ciudadService.getAllCiudades();
    }
    @GetMapping("/{id-ciudad}")
    public CiudadDto getCiudadByIdCiudad(@PathVariable("id-ciudad") Integer idciudad){
        return ciudadService.getCiudadByIdCiudad(idciudad);
    }

}
