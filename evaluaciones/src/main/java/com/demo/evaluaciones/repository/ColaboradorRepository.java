package com.demo.evaluaciones.repository;



import org.springframework.data.mongodb.repository.MongoRepository;


import com.demo.evaluaciones.model.Colaborador;



public interface ColaboradorRepository extends MongoRepository<Colaborador, String> {

}
