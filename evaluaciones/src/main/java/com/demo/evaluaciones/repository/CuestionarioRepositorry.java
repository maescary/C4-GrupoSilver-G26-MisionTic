package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Cuestionario;

@Repository
public interface CuestionarioRepositorry extends MongoRepository<Cuestionario, String>{

}
