package com.qindel.practicas.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JJOOController {

    @GetMapping("/jjoo")
    public JJOO jjoo(@RequestParam(value = "id_pais") Integer id_pais) {
        ArrayList<JJOO> lista = new ArrayList<JJOO>();
        ArrayList<JJOO> listaFinal = new ArrayList<JJOO>();
        lista.add(new JJOO(1, "España", 1, "Barcelona", 200, "verano"));
        lista.add(new JJOO(2, "Francia", 2, "Paris", 300, "verano"));
        lista.add(new JJOO(3, "Portugal", 33, "Lisboa", 111, "invierno"));
        lista.add(new JJOO(4, "Alemania", 55, "Berlin", 500, "verano"));


        for (int i = 0; i < lista.size(); i++){
            if (id_pais == lista.get(i).id_pais()){
                listaFinal.add(lista.get(i));
            }
        }
        return listaFinal.get(0);
    }
}