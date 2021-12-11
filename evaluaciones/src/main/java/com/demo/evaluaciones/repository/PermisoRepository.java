package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Permiso;

@Repository
public interface PermisoRepository extends MongoRepository<Permiso, String> {

}
