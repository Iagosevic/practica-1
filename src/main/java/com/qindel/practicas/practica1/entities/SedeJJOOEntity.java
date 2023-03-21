package com.qindel.practicas.practica1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "aplicacion_web", name = "SEDE_JJOO")
@IdClass(SedeJJOOPKEntity.class)
public class SedeJJOOEntity {
    @Id
    private Integer anho;
    @Id
    private Integer id_tipo_jjoo;
    @Id
    private Integer sede;


}


