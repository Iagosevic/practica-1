package com.qindel.practicas.practica1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
public class JJOOEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id_pais;
    private String nombre_pais;
    private Integer id_ciudad;
    private String nombre_ciudad;
    private Integer valor;
    private String descripcion;

    public JJOOEntity() {}

    public JJOOEntity(Integer id_pais, String nombre_pais, Integer id_ciudad, String nombre_ciudad,
                      Integer valor, String descripcion) {
        this.id_pais = id_pais;
        this.nombre_pais = nombre_pais;
        this.id_ciudad = id_ciudad;
        this.nombre_ciudad = nombre_ciudad;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format(
                "Juegos Olimpicos[id_pais=%d, nombre_pais='%s', id_ciudad=%d, nombre_ciudad='%s'," +
                        "valor=%d, descripcion='%s']",
                id_pais, nombre_pais, id_ciudad, nombre_ciudad, valor, descripcion);
    }

    public Integer getId_pais() {
        return id_pais;
    }

    public void setId_pais(Integer id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
