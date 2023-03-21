package com.qindel.practicas.practica1.entities;

import jakarta.persistence.*;
@Entity
@Table(schema = "aplicacion_web", name = "TIPO_JJOO")
public class TipoJJOOEntity {
    @Id
    @Column (name = "id_tipo_jjoo")
    private Integer id_tipo_jjoo;
    @Column (name = "descripcion_tipo")
    private String descripcion_tipo;

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
}
