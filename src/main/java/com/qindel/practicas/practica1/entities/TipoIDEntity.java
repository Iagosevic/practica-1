package com.qindel.practicas.practica1.entities;

import java.io.Serializable;
import java.util.Objects;

public class TipoIDEntity implements Serializable {

    private Integer idtipojjoo;
    private String descripciontipo;

    public TipoIDEntity(Integer idtipojjoo, String descripciontipo) {
        this.idtipojjoo = idtipojjoo;
        this.descripciontipo = descripciontipo;
    }

    public TipoIDEntity() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtipojjoo, descripciontipo);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TipoIDEntity other = (TipoIDEntity) obj;
        return Objects.equals(idtipojjoo, other.descripciontipo) && Objects.equals(idtipojjoo, other.descripciontipo);
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