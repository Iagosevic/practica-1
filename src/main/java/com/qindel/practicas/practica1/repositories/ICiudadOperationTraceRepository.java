package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.operationtraces.CiudadOperationTrace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICiudadOperationTraceRepository  extends MongoRepository<CiudadOperationTrace, String> {

}
