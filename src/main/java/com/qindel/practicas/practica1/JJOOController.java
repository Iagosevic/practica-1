package com.qindel.practicas.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/juego-olimpico")

public class JJOOController {

    @Autowired
    private JJOORepository repository;

    @GetMapping
    public ResponseEntity<List<JJOOEntity>> consultarJuegosOlimpicos() {
        List<JJOOEntity> juegosOlimpicos = repository.findAll();
        return ResponseEntity.ok(juegosOlimpicos);
    }
}
