package com.qindel.practicas.practica1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudad")
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_ciudad;
    private String nombre_ciudad;
    private Integer id_pais;
    private Integer valor_ciudad;

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public Integer getValor_ciudad() {
        return valor_ciudad;
    }

    public void setValor_ciudad(Integer valor_ciudad) {
        this.valor_ciudad = valor_ciudad;
    }
}
