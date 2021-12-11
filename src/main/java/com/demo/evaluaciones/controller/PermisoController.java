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

import com.demo.evaluaciones.model.Permiso;
import com.demo.evaluaciones.serviceInterface.PermisoServiceInterface;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/permisos")
public class PermisoController {
	
	@Autowired
	private PermisoServiceInterface servicio;
	
	
	@GetMapping
	public List<Permiso> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Permiso> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Permiso creado correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public Permiso save(@RequestBody Permiso permiso) {
		return servicio.save(permiso);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Permiso update(@PathVariable String id, @RequestBody Permiso permiso) {	
		Optional<Permiso> op = servicio.findById(id);
		
		Permiso permisoUpdate = new Permiso();
		if (!op.isEmpty()) {			
			permisoUpdate = op.get();
				
			permisoUpdate= permiso;			
			permisoUpdate.setId(id);
			
			permisoUpdate.setPermiso(permiso.getPermiso());
			
		}
		return servicio.save(permisoUpdate);
				
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	


}
