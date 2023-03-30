package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.entities.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoRepository extends JpaRepository<TipoEntity, Integer> {
    /*TipoEntity findByDescripciontipo(String descripciontipo);
    TipoEntity findByIdtipojjoo(Integer idtipojjoo);*/
}
