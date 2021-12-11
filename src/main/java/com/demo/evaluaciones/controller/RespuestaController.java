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

import com.demo.evaluaciones.model.Respuesta;
import com.demo.evaluaciones.serviceInterface.RespuestaServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

	@Autowired
	private RespuestaServiceInterface servicio;
	
	
	@GetMapping
	public List<Respuesta> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Respuesta> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Respuesta creada correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public void save(@RequestBody Respuesta respuesta) {
		  servicio.save(respuesta);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Respuesta update(@PathVariable String id, @RequestBody Respuesta respuesta) {	
		Optional<Respuesta> op = servicio.findById(id);
		
		Respuesta respuestaUpdate = new Respuesta();
		if (!op.isEmpty()) {			
			respuestaUpdate = op.get();
			
			respuestaUpdate= respuesta;			
			respuestaUpdate.setId(id);
			
			respuestaUpdate.setDescripcion(respuesta.getDescripcion());
			respuestaUpdate.setEstado(respuesta.isEstado());
			respuestaUpdate.setValor(respuesta.getValor());
			
			
			servicio.save(respuestaUpdate);
				
	  }
       return respuesta;
    }

	


	
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	


}