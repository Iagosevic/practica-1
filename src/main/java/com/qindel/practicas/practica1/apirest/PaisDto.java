package com.qindel.practicas.practica1.apirest;

public class PaisDto {
    private Integer idpais;
    private String nombrepais;
    private String codigopais;
    private Integer valorpais;

    public PaisDto(Integer idpais, String nombrepais, String codigopais, Integer valorpais) {
        this.idpais = idpais;
        this.nombrepais = nombrepais;
        this.codigopais = codigopais;
        this.valorpais = valorpais;
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
