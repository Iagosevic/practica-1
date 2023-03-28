package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.SedeIDEntity;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.entities.TipoIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITipoRepository extends JpaRepository<TipoEntity, TipoIDEntity> {
    TipoEntity findByDescripciontipo(String descripciontipo);
    TipoEntity findByIdtipojjoo(Integer idtipojjoo);
}
