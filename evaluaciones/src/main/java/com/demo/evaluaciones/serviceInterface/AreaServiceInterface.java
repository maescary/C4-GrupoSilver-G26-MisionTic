package com.demo.evaluaciones.serviceInterface;


import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Area;



public interface AreaServiceInterface {

	public List<Area> all();

	public Optional<Area> findById(String id);
	
	public Area save(Area area);
	
	public void delete(String id);
}
