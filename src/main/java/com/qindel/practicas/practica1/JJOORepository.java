package com.qindel.practicas.practica1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@SpringBootApplication
@Repository

public interface JJOORepository extends JpaRepository<JJOOEntity, Long> {

    List<JJOOEntity> findByLastName(String nombre_ciudad);

    JJOOEntity findById(long id_ciudad);
}
