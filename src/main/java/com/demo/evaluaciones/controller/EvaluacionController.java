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

import com.demo.evaluaciones.model.Evaluacion;
import com.demo.evaluaciones.serviceInterface.EvaluacionServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

	@Autowired
	private EvaluacionServiceInterface servicio;
	
	
	@GetMapping
	public List<Evaluacion> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Evaluacion> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Evaluacion creada correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public void save(@RequestBody Evaluacion evaluacion) {
		  servicio.save(evaluacion);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Evaluacion update(@PathVariable String id, @RequestBody Evaluacion evaluacion) {	
		Optional<Evaluacion> op = servicio.findById(id);
		
		Evaluacion evaluacionUpdate = new Evaluacion();
		if (!op.isEmpty()) {			
			evaluacionUpdate = op.get();
			
			evaluacionUpdate= evaluacion;			
		
			
			servicio.save(evaluacionUpdate);
				
	  }
       return evaluacion;
    }

	


	
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	


}