package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Respuesta;
import com.demo.evaluaciones.repository.RespuestaRepository;
import com.demo.evaluaciones.serviceInterface.RespuestaServiceInterface;

@Service
public class RespuestaService implements RespuestaServiceInterface {
	
	
	@Autowired
	private RespuestaRepository repository;

	@Override
	public List<Respuesta> all() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Respuesta> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Respuesta save(Respuesta respuesta) {
		
		return repository.save(respuesta);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
		
	}
	
	

}
