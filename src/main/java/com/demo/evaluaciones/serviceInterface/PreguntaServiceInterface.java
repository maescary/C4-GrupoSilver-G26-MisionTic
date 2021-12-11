package com.demo.evaluaciones.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Pregunta;

public interface PreguntaServiceInterface {
	
	public List<Pregunta> all();

	public Optional<Pregunta> findById(String id);
	
	public Pregunta save(Pregunta pregunta);
	
	public void delete(String id);

}
