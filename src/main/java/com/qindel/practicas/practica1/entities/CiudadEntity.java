package com.qindel.practicas.practica1.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciudad")
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Integer idciudad;
    @Column(name = "nombre_ciudad")
    private String nombreciudad;
    @Column(name = "id_pais")
    private Integer idpais;
    @Column(name = "valor_ciudad")
    private Integer valorciudad;


    public CiudadEntity(Integer idciudad, String nombreciudad, Integer idpais, Integer valorciudad) {
        this.idciudad = idciudad;
        this.nombreciudad = nombreciudad;
        this.idpais = idpais;
        this.valorciudad = valorciudad;
    }



    public CiudadEntity() {

    }

    public Integer getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }

    public String getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public Integer getValorciudad() {
        return valorciudad;
    }

    public void setValorciudad(Integer valorciudad) {
        this.valorciudad = valorciudad;
    }

}
