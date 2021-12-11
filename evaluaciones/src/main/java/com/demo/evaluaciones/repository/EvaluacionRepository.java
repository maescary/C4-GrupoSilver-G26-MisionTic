package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Evaluacion;


@Repository
public interface EvaluacionRepository extends MongoRepository<Evaluacion, String>{

}
