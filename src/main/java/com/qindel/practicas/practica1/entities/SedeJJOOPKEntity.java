package com.qindel.practicas.practica1.entities;

import java.io.Serializable;
import java.util.Objects;

public class SedeJJOOPKEntity implements Serializable {

    private Integer anho;

    private Integer id_tipo_jjoo;

    public SedeJJOOPKEntity(Integer anho, Integer id_tipo_jjoo) {
        this.anho = anho;
        this.id_tipo_jjoo = id_tipo_jjoo;
    }

    public SedeJJOOPKEntity() {
    }

    //Getters and setters
    public Integer getId_tipo_jjoo() {
        return id_tipo_jjoo;
    }

    public void setId_tipo_jjoo(Integer id_tipo_jjoo) {
        this.id_tipo_jjoo = id_tipo_jjoo;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }


    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        SedeJJOOPKEntity pk = (SedeJJOOPKEntity) o;
        return Objects.equals( anho, pk.anho ) &&
                Objects.equals( id_tipo_jjoo, pk.id_tipo_jjoo );
    }

    @Override
    public int hashCode() {
        return Objects.hash( anho, id_tipo_jjoo );
    }


}
