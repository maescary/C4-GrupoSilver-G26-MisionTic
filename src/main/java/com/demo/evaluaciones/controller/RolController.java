package com.demo.evaluaciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.demo.evaluaciones.model.Rol;
import com.demo.evaluaciones.serviceInterface.RolServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/roles")
public class RolController  {

	@Autowired
	private RolServiceInterface servicio;
	
	
	@GetMapping
	public List<Rol> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Rol> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Rol creado correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public Rol save(@RequestBody Rol rol) {
		return servicio.save(rol);
		
		
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Rol update(@PathVariable String id, @RequestBody Rol rol) {	
		Optional<Rol> op = servicio.findById(id);
		
		Rol rolUpdate = new Rol();
		if (!op.isEmpty()) {			
			rolUpdate = op.get();
			
			rolUpdate=rol;			
			rolUpdate.setId(id);
			rolUpdate.setEstado(rol.isEstado());
			rolUpdate.setPermisos(rol.getPermisos());
			rolUpdate.setRol_name(rol.getRol_name());
			
			return servicio.save(rolUpdate);
			
		}
		
		return rol;		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	
	

}
