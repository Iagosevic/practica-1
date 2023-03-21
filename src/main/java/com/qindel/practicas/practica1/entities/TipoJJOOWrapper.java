package com.qindel.practicas.practica1.entities;

import java.util.ArrayList;
import java.util.List;

public class TipoJJOOWrapper {

    private List<TipoJJOOEntity> tipos = new ArrayList<TipoJJOOEntity>();

    public TipoJJOOWrapper(){

    }

    public List<TipoJJOOEntity> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoJJOOEntity> tipos) {
        this.tipos = tipos;
    }
}
