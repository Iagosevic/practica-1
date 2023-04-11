package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.services.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private ITipoService tipoService;

    @GetMapping("")
    public List<TipoEntity> getTipos(){
        return tipoService.getAllTipos();
    }
    @GetMapping("/{id-tipo-jjoo}")
    public TipoDto getTipoById(@PathVariable("id-tipo-jjoo") Integer idtipojjoo){
        return tipoService.getTipoById(idtipojjoo);
    }
}
