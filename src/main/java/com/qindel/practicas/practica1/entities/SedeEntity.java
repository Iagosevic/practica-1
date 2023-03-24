package com.qindel.practicas.practica1.entities;

import jakarta.persistence.*;
@Entity
@IdClass(SedeIDEntity.class)
@Table(name="sede_jjoo")
public class SedeEntity {

    @Id
    @Column(name="anho")
    private Integer anho;

    @Id
    @Column(name="id_tipo_jjoo")
    private Integer idtipojjoo;

    @Column(name="sede")
    private Integer sede;



    public SedeEntity() {
    }

    public SedeEntity(Integer anho, Integer idtipojjoo, Integer sede) {
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