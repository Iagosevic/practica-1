package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.services.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private ITipoService tipoService;

    @GetMapping("")
    public List<TipoDto> getTipos(){
        return tipoService.getAllTipos();
    }
    @GetMapping("/{id-tipo-jjoo}")
    public TipoDto getTipoById(@PathVariable("id-tipo-jjoo") Integer idtipojjoo){
        return tipoService.getTipoById(idtipojjoo);
    }
    @PostMapping("/tipo")
    public TipoDto addTipo(@RequestBody TipoDto nuevoTipo) {
        return tipoService.addTipo(nuevoTipo);
    }
    @PutMapping("/tipo/{idtipo}")
    public TipoDto updateTipo(@PathVariable Integer idtipo, @RequestBody TipoDto nuevoTipo) {
        TipoDto tipoEditar = tipoService.getTipoById(idtipo);

        tipoEditar.setDescripciontipo(nuevoTipo.getDescripciontipo());

        return tipoService.updateTipo(nuevoTipo, idtipo);
    }

    @DeleteMapping("/tipo/{idtipo}")
    public void deleteTipo(@PathVariable Integer idtipo) {
        tipoService.deleteTipo(idtipo);
    }
}