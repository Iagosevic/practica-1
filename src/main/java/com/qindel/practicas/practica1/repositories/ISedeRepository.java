package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.SedeIDEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISedeRepository extends JpaRepository <SedeEntity, SedeIDEntity> {
}
