package com.qindel.practicas.practica1;

import java.util.List;

public class JJOOWrapper {

    private List<JJOO> juegosOlimpicos;

    public JJOOWrapper (List<JJOO> juegosOlimpicos){
        this.juegosOlimpicos = juegosOlimpicos;
    }

    public List<JJOO> getJuegosOlimpicos() {
        return juegosOlimpicos;
    }

    public void setJuegosOlimpicos(List<JJOO> juegosOlimpicos) {
        this.juegosOlimpicos = juegosOlimpicos;
    }
}
