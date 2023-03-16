package com.qindel.practicas.practica1.wrappers;

import com.qindel.practicas.practica1.entities.JJOOEntity;
import com.qindel.practicas.practica1.records.JJOO;

import java.util.List;

public class JJOOWrapper {

    private List<JJOOEntity> juegosOlimpicos;

    public JJOOWrapper (List<JJOOEntity> juegosOlimpicos){
        this.juegosOlimpicos = juegosOlimpicos;
    }

    public List<JJOOEntity> getJuegosOlimpicos() {
        return juegosOlimpicos;
    }

    public void setJuegosOlimpicos(List<JJOOEntity> juegosOlimpicos) {
        this.juegosOlimpicos = juegosOlimpicos;
    }
}
