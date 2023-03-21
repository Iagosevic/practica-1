package com.qindel.practicas.practica1.entities;

import java.util.ArrayList;
import java.util.List;

public class PaisWrapper {
    List<PaisEntity> paises = new ArrayList<PaisEntity>();

    public PaisWrapper(){

    }

    public List<PaisEntity> getPaises() {
        return paises;
    }

    public void setPaises(List<PaisEntity> paises) {
        this.paises = paises;
    }
}
