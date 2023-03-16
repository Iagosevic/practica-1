package com.qindel.practicas.practica1.controllers;

import java.util.List;

import com.qindel.practicas.practica1.entities.JJOOEntity;
import com.qindel.practicas.practica1.records.JJOO;
import com.qindel.practicas.practica1.repositories.JJOORepository;
import com.qindel.practicas.practica1.wrappers.JJOOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/juego-olimpico")

public class JJOOController {

    @Autowired
    private JJOORepository repository;

    @GetMapping
    public JJOOWrapper consultarJuegosOlimpicos() {
        //List<JJOOEntity> juegosOlimpicos = repository.findAll();
        JJOOWrapper juegosOlimpicos2 = new JJOOWrapper(repository.findAll());
        return juegosOlimpicos2;
    }
}
