package com.qindel.practicas.practica1.apirest;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class SedeDto {

    private Integer anho;

    private Integer idtipojjoo;

    private Integer sede;

    public SedeDto(Integer anho, Integer idtipojjoo, Integer sede) {
        this.anho = anho;
        this.idtipojjoo = idtipojjoo;
        this.sede = sede;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public Integer getIdtipojjoo() {
        return idtipojjoo;
    }

    public void setIdtipojjoo(Integer idtipojjoo) {
        this.idtipojjoo = idtipojjoo;
    }

    public Integer getSede() {
        return sede;
    }

    public void setSede(Integer sede) {
        this.sede = sede;
    }
}
