package com.demo.evaluaciones.serviceInterface;


import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Permiso;




public interface PermisoServiceInterface {

	public List<Permiso> all();

	public Optional<Permiso> findById(String id);
	
	public Permiso save(Permiso permiso);
	
	public void delete(String id);
	
	
	
}
