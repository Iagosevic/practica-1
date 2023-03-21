package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.entities.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPaisRepository extends JpaRepository<PaisEntity, Integer> {

}
