package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.services.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private ITipoService tipoService;
    @PreAuthorize("hasRole('USER')")
    @GetMapping("")
    public List<TipoDto> getTipos(){
        return tipoService.getAllTipos();
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id-tipo-jjoo}")
    public TipoDto getTipoById(@PathVariable("id-tipo-jjoo") Integer idtipojjoo){
        return tipoService.getTipoById(idtipojjoo);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/tipo")
    public TipoDto addTipo(@RequestBody TipoDto nuevoTipo) {
        return tipoService.addTipo(nuevoTipo);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tipo/{id-tipo-jjoo}")
    public TipoDto updateTipo(@PathVariable("id-tipo-jjoo") Integer idtipo, @RequestBody TipoDto nuevoTipo) {
        TipoDto tipoEditar = tipoService.getTipoById(idtipo);

        tipoEditar.setDescripciontipo(nuevoTipo.getDescripciontipo());

        return tipoService.updateTipo(nuevoTipo, idtipo);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/tipo/{id-tipo-jjoo}")
    public void deleteTipo(@PathVariable("id-tipo-jjoo") Integer idtipo) {
        tipoService.deleteTipo(idtipo);
    }
}