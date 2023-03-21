package com.qindel.practicas.practica1.repositories;


import com.qindel.practicas.practica1.entities.CiudadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICiudadRepository extends JpaRepository<CiudadEntity, Integer> {

}

