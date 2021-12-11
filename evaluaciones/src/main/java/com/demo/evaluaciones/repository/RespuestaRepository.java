package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Respuesta;

@Repository
public interface RespuestaRepository extends MongoRepository<Respuesta, String>{

}
