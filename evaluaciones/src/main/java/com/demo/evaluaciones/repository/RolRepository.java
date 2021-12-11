package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Rol;

@Repository
public interface RolRepository extends MongoRepository<Rol, String>{
	
	

}
