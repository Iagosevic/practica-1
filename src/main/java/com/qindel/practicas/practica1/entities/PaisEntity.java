package com.qindel.practicas.practica1.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 @Entity
 @Table(schema = "aplicacion_web", name = "PAIS")
    public class PaisEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column (name = "id_pais")
     private Integer id_pais;
     @Column (name = "nombre_pais")
     private String nombre_pais;
     @Column (name = "codigo_pais")
     private String codigo_pais;
     @Column (name = "valor_pais")
     private Integer valor_pais;

 }
