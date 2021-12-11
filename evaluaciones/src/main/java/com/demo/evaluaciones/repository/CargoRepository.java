package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Cargo;

@Repository
public interface CargoRepository extends MongoRepository<Cargo, String> {

}
