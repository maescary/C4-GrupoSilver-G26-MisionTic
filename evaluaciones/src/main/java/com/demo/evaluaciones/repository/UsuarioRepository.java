package com.demo.evaluaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.evaluaciones.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
