package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Categoria;

@Repository
public interface CategoriaRepository  extends MongoRepository<Categoria, String>{

}
