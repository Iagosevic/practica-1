package com.qindel.practicas.practica1.entities;

import java.util.ArrayList;
import java.util.List;

public class CiudadWrapper {

    private List<CiudadEntity> ciudades = new ArrayList<CiudadEntity>();

    public CiudadWrapper(){

    }

    public List<CiudadEntity> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<CiudadEntity> ciudades) {
        this.ciudades = ciudades;
    }
}
