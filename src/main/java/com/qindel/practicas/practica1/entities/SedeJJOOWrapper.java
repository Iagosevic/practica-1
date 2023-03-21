package com.qindel.practicas.practica1.entities;

import java.util.ArrayList;
import java.util.List;

public class SedeJJOOWrapper {

    private List<SedeJJOOEntity> sedes = new ArrayList<SedeJJOOEntity>();

    public SedeJJOOWrapper(){

    }

    public List<SedeJJOOEntity> getSedes() {
        return sedes;
    }

    public void setSedes(List<SedeJJOOEntity> sedes) {
        this.sedes = sedes;
    }
}
