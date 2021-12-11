package com.demo.evaluaciones.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Cuestionario;

public interface CuestionarioServiceInterface {
	
	public List<Cuestionario> all();

	public Optional<Cuestionario> findById(String id);
	
	public Cuestionario save(Cuestionario cuestionario);
	
	public void delete(String id);

}
