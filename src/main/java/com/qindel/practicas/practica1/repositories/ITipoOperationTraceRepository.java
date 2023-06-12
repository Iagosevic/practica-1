package com.qindel.practicas.practica1.repositories;

import com.qindel.practicas.practica1.operationtraces.PaisOperationTrace;
import com.qindel.practicas.practica1.operationtraces.TipoOperationTrace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoOperationTraceRepository extends MongoRepository<TipoOperationTrace, String> {
}
