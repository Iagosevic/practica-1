package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private ICiudadRepository ciudadRepo;

    @GetMapping("")
    public List<CiudadEntity> getCiudades(){
        return ciudadRepo.findAll();
    }

    @GetMapping("/{id-ciudad}")
    public CiudadEntity getCiudadById(@PathVariable("id-ciudad") Integer idciudad){
        return ciudadRepo.findByIdciudad(idciudad);
    }

/*    @GetMapping("/ciudad/{nombre-ciudad}")
    public CiudadEntity getCiudadByNombre(@RequestParam("nombre-ciudad") String nombreciudad){
        System.out.println("aaaaaaaaaaaaaaaaaaaa"+nombreciudad);
        return ciudadRepo.findByNombreciudad(nombreciudad);
    }*/

}
