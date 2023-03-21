package com.qindel.practicas.practica1.repositories;


import com.qindel.practicas.practica1.entities.TipoJJOOEntity;
import com.qindel.practicas.practica1.entities.TipoJJOOPKEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoJJOORepository extends JpaRepository<TipoJJOOEntity, Integer> {

}