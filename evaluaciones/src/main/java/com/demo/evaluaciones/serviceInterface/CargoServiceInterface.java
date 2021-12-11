package com.demo.evaluaciones.serviceInterface;


import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Cargo;



public interface CargoServiceInterface {

	public List<Cargo> all();

	public Optional<Cargo> findById(String id);
	
	public Cargo save(Cargo cargo);
	
	public void delete(String id);
}
