package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.entities.SedeJJOOEntity;
import com.qindel.practicas.practica1.entities.SedeJJOOPKEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISedeJJOORepository extends JpaRepository<SedeJJOOEntity, SedeJJOOPKEntity> {

}
