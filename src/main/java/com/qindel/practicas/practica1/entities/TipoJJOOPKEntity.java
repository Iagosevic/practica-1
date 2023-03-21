package com.qindel.practicas.practica1.entities;

import java.io.Serializable;
import java.util.Objects;

public class TipoJJOOPKEntity implements Serializable {

    private Integer id_tipo_jjoo;

    private String descripcion_tipo;

    public TipoJJOOPKEntity(Integer id_tipo_jjoo, String descripcion_tipo) {
        this.id_tipo_jjoo = id_tipo_jjoo;
        this.descripcion_tipo = descripcion_tipo;
    }

    public TipoJJOOPKEntity() {
    }

    //Getters and setters
    public Integer getId_tipo_jjoo() {
        return id_tipo_jjoo;
    }

    public void setId_tipo_jjoo(Integer id_tipo_jjoo) {
        this.id_tipo_jjoo = id_tipo_jjoo;
    }

    public String getDescripcion_tipo() {
        return descripcion_tipo;
    }

    public void setDescripcion_tipo(String descripcion_tipo) {
        this.descripcion_tipo = descripcion_tipo;
    }


    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        TipoJJOOPKEntity pk = (TipoJJOOPKEntity) o;
        return Objects.equals( id_tipo_jjoo, pk.id_tipo_jjoo ) &&
                Objects.equals( descripcion_tipo, pk.descripcion_tipo );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id_tipo_jjoo, descripcion_tipo );
    }


}
