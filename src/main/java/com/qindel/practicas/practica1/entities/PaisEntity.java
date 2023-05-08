package com.qindel.practicas.practica1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pais")
public class PaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Integer idpais;
    @Column(name = "nombre_pais")
    private String nombrepais;
    @Column(name = "codigo_pais")
    private String codigopais;
    @Column(name = "valor_pais")
    private Integer valorpais;

    public PaisEntity(Integer idpais, String nombrepais, String codigopais, Integer valorpais) {
        this.idpais = idpais;
        this.nombrepais = nombrepais;
        this.codigopais = codigopais;
        this.valorpais = valorpais;
    }

    public PaisEntity() {
    }
    public Integer getIdpais() {
        return idpais;
    }
    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }
    public String getNombrepais() {
        return nombrepais;
    }
    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }
    public String getCodigopais() {
        return codigopais;
    }
    public void setCodigopais(String codigopais) {
        this.codigopais = codigopais;
    }
    public Integer getValorpais() {
        return valorpais;
    }
    public void setValorpais(Integer valorpais) {
        this.valorpais = valorpais;
    }
}
