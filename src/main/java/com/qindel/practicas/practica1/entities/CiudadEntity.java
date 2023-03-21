package com.qindel.practicas.practica1.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.entities.PaisEntity;

@Getter
@Setter
@Entity
@Table(schema = "aplicacion_web", name = "CIUDAD")
public class CiudadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_ciudad")
    private Integer id_ciudad;
    @Column (name = "nombre_ciudad")
    private String nombre_ciudad;
    @Column (name = "id_pais")
    private Integer id_pais;

    @Column (name = "valor_ciudad")
    private Integer valor_ciudad;

}
