package com.qindel.practicas.practica1.entities;

import java.io.Serializable;
import java.util.Objects;

public class SedeIDEntity implements Serializable {
    private Integer anho;
    private Integer idtipojjoo;
    public SedeIDEntity() {

    }
    public SedeIDEntity(Integer anho, Integer idtipojjoo) {
        super();
        this.anho = anho;
        this.idtipojjoo = idtipojjoo;
    }
    @Override
    public int hashCode() {
        return Objects.hash(anho, idtipojjoo);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SedeIDEntity other = (SedeIDEntity) obj;
        return Objects.equals(anho, other.anho) && Objects.equals(idtipojjoo, other.idtipojjoo);
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
}
