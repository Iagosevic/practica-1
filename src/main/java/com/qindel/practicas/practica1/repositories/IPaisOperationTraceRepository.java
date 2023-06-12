package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.operationtraces.CiudadOperationTrace;
import com.qindel.practicas.practica1.operationtraces.PaisOperationTrace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisOperationTraceRepository extends MongoRepository<PaisOperationTrace, String> {
}
