package com.demo.evaluaciones.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Respuesta;

public interface RespuestaServiceInterface {
	
	public List<Respuesta> all();

	public Optional<Respuesta> findById(String id);
	
	public Respuesta save(Respuesta respuesta);
	
	public void delete(String id);

}
