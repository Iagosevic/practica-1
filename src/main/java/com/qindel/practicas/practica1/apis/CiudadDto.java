package com.qindel.practicas.practica1.apis;

import com.qindel.practicas.practica1.entities.PaisEntity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CiudadDto {

    private Integer id_ciudad;
    private String nombre_ciudad;
    private Integer id_pais;
    private Integer valor_ciudad;
}
