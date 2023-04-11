package com.qindel.practicas.practica1.apirest;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TipoDto {

    private Integer idtipojjoo;

    private String descripciontipo;

    public TipoDto(Integer idtipojjoo, String descripciontipo) {
        this.idtipojjoo = idtipojjoo;
        this.descripciontipo = descripciontipo;
    }

    public Integer getIdtipojjoo() {
        return idtipojjoo;
    }

    public void setIdtipojjoo(Integer idtipojjoo) {
        this.idtipojjoo = idtipojjoo;
    }

    public String getDescripciontipo() {
        return descripciontipo;
    }

    public void setDescripciontipo(String descripciontipo) {
        this.descripciontipo = descripciontipo;
    }
}
