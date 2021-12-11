package com.demo.evaluaciones.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Categoria;

public interface CategoriaServiceInterface {
	
	public List<Categoria> all();

	public Optional<Categoria> findById(String id);
	
	public Categoria save(Categoria categoria);
	
	public void delete(String id);

}
