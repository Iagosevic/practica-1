package com.qindel.practicas.practica1.apirest;

public class TipoDto {

    private Integer idtipojjoo;
    private String descripciontipo;

    public TipoDto(Integer idtipojjoo, String descripciontipo) {
        this.idtipojjoo = idtipojjoo;
        this.descripciontipo = descripciontipo;
    }

    public TipoDto() {

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
