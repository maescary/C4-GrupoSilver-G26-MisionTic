package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Evaluacion;
import com.demo.evaluaciones.repository.EvaluacionRepository;
import com.demo.evaluaciones.serviceInterface.EvaluacionServiceInterface;

@Service
public class EvaluacionService implements EvaluacionServiceInterface{

	@Autowired
	private EvaluacionRepository repository;
	
	@Override
	public List<Evaluacion> all() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Evaluacion> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Evaluacion save(Evaluacion evaluacion) {
		
		return repository.save(evaluacion);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
		
	}

}
