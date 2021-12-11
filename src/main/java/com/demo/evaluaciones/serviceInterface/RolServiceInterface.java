package com.demo.evaluaciones.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Rol;

public interface RolServiceInterface {

	public List<Rol> all();

	public Optional<Rol> findById(String id);
	
	public Rol save(Rol rol);
	
	public void delete(String id);
	
}
