package com.demo.evaluaciones.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Evaluacion;

public interface EvaluacionServiceInterface {
	
	public List<Evaluacion> all();

	public Optional<Evaluacion> findById(String id);
	
	public Evaluacion save(Evaluacion evaluacion);
	
	public void delete(String id);
	

}
