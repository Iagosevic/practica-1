package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.entities.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisRepository extends JpaRepository<PaisEntity, Integer> {

    /*PaisEntity findByIdpais(Integer idpais);
    PaisEntity findByNombrepais(String nombrepais);*/

}
