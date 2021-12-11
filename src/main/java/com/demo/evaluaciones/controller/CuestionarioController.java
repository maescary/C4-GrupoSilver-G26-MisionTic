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

import com.demo.evaluaciones.model.Cuestionario;
import com.demo.evaluaciones.serviceInterface.CuestionarioServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cuestionarios")
public class CuestionarioController {

	@Autowired
	private CuestionarioServiceInterface servicio;
	
	
	@GetMapping
	public List<Cuestionario> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Cuestionario> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Cuestionario creado correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public void save(@RequestBody Cuestionario cuestionario) {
		  servicio.save(cuestionario);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cuestionario update(@PathVariable String id, @RequestBody Cuestionario cuestionario) {	
		Optional<Cuestionario> op = servicio.findById(id);
		
		Cuestionario cuestionarioUpdate = new Cuestionario();
		if (!op.isEmpty()) {			
			cuestionarioUpdate = op.get();
			
			cuestionarioUpdate= cuestionario;			
			cuestionarioUpdate.setId(id);
			
			cuestionarioUpdate.setEstado(cuestionario.isEstado());
			cuestionarioUpdate.setNombre(cuestionario.getNombre());
			cuestionarioUpdate.setSeccion_preguntas(cuestionario.getSeccion_preguntas());
			cuestionarioUpdate.setTotal_seccion(cuestionario.getTotal_seccion());
			
			servicio.save(cuestionarioUpdate);
				
	  }
       return cuestionario;
    }

	


	
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	


}