package com.qindel.practicas.practica1.apirest;

public class CiudadDto {
    private Integer idciudad;
    private String nombreciudad;
    private Integer idpais;
    private Integer valorciudad;

    public CiudadDto(Integer idciudad, String nombreciudad, Integer idpais, Integer valorciudad) {
        this.idciudad = idciudad;
        this.nombreciudad = nombreciudad;
        this.idpais = idpais;
        this.valorciudad = valorciudad;
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
