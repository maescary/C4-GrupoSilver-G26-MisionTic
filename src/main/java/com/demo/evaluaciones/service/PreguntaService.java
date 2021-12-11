package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Pregunta;
import com.demo.evaluaciones.repository.PreguntaRepository;
import com.demo.evaluaciones.serviceInterface.PreguntaServiceInterface;

@Service
public class PreguntaService implements PreguntaServiceInterface{

	@Autowired
	private PreguntaRepository repository;
	
	
	@Override
	public List<Pregunta> all() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Pregunta> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Pregunta save(Pregunta pregunta) {
		
		return repository.save(pregunta);
	}

	@Override
	public void delete(String id) {
		
		repository.deleteById(id);
	}

}
