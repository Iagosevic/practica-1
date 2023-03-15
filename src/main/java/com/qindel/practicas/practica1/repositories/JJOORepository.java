package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.entities.JJOOEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JJOORepository extends JpaRepository<JJOOEntity, Long> {

    List<JJOOEntity> findByLastName(String nombre_ciudad);

    JJOOEntity findById(long id_ciudad);
}
