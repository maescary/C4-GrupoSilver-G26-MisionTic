package com.demo.evaluaciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.evaluaciones.model.Area;
import com.demo.evaluaciones.serviceInterface.AreaServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/areas")
public class AreaController {
	
	@Autowired
	private AreaServiceInterface servicio;
	
	
	@GetMapping
	public List<Area> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Area> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Area creada correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public Area save(@RequestBody Area area) {
		return servicio.save(area);
	}
	

	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	


}
