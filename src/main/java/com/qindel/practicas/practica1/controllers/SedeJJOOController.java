package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.entities.SedeJJOOWrapper;
import com.qindel.practicas.practica1.entities.TipoJJOOWrapper;
import com.qindel.practicas.practica1.apis.SedeJJOODto;
import com.qindel.practicas.practica1.apis.TipoJJOODto;
import com.qindel.practicas.practica1.services.ISedeJJOOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SedeJJOOController {

    private ISedeJJOOService sedeServ;

    @Autowired
    public SedeJJOOController(ISedeJJOOService sedeServ) {
        this.sedeServ = sedeServ;
    }

    @GetMapping("/juego-olimpico")
    @ResponseStatus(code= HttpStatus.OK)
    public SedeJJOOWrapper getJO() {
        return sedeServ.getJJOOs();
    }

    @GetMapping("/juego-olimpico/id-anno/{idAnno}/id-tipo/{idTipo}")
    @ResponseStatus(code=HttpStatus.OK)
    public SedeJJOODto getJJOO(@PathVariable Integer idAnno, @PathVariable Integer idTipo) {
        return sedeServ.getJJOO(idAnno, idTipo);
    }

    @GetMapping("/tipo-jjoo")
    @ResponseStatus(code=HttpStatus.OK)
    public TipoJJOOWrapper getTipos() {

        return sedeServ.getTipos();
    }

    @GetMapping("/tipo-jjoo/{idTipo}")
    @ResponseStatus(code=HttpStatus.OK)
    public TipoJJOODto getTipo(@PathVariable Integer idTipo) {
        return sedeServ.getTipo(idTipo);
    }


}
