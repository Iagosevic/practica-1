package com.qindel.practicas.practica1.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tipo_jjoo")
public class TipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_jjoo")
    private Integer idtipojjoo;
    @Column(name="descripcion_tipo")
    private String descripciontipo;
    public TipoEntity() {
    }

    public TipoEntity(Integer idtipojjoo, String descripciontipo) {
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
