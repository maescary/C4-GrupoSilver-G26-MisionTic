package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Pregunta;

@Repository
public interface PreguntaRepository   extends MongoRepository<Pregunta, String>{

}
