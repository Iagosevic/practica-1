package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.repositories.ISedeRepository;
import com.qindel.practicas.practica1.repositories.ITipoRepository;
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
    private ITipoRepository tipoRepo;

    @GetMapping("/all")
    public List<TipoEntity> getTipos(){
        return tipoRepo.findAll();
    }

    @GetMapping("/{idtipojjoo}")
    public TipoEntity getTipoById(@PathVariable Integer idtipojjoo){
        return tipoRepo.findByIdtipojjoo(idtipojjoo);
    }

    @GetMapping("/tipo/{descripciontipo}")
    public TipoEntity getTipoByDescripcion(@PathVariable String descripciontipo){
        return tipoRepo.findByDescripciontipo(descripciontipo);
    }
}
