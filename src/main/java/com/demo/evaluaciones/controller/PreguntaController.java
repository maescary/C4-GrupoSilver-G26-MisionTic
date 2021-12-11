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

import com.demo.evaluaciones.model.Pregunta;
import com.demo.evaluaciones.serviceInterface.PreguntaServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

	@Autowired
	private PreguntaServiceInterface servicio;
	
	
	@GetMapping
	public List<Pregunta> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Pregunta> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Pregunta creada correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public void save(@RequestBody Pregunta pregunta) {
		  servicio.save(pregunta);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pregunta update(@PathVariable String id, @RequestBody Pregunta pregunta) {	
		Optional<Pregunta> op = servicio.findById(id);
		
		Pregunta preguntaUpdate = new Pregunta();
		if (!op.isEmpty()) {			
			preguntaUpdate = op.get();
			
			preguntaUpdate= pregunta;			
			preguntaUpdate.setId(id);
			preguntaUpdate.setCategoria(pregunta.getCategoria());
			preguntaUpdate.setEnunciado(pregunta.getEnunciado());
			preguntaUpdate.setOpciones_res(pregunta.getOpciones_res());
			preguntaUpdate.setValor_pregunta(pregunta.isValor_pregunta());
			
			servicio.save(preguntaUpdate);
				
	  }
       return pregunta;
    }

	


	
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	


}