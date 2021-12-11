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

import com.demo.evaluaciones.model.Colaborador;
import com.demo.evaluaciones.serviceInterface.ColaboradorServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorServiceInterface servicio;
	
	
	@GetMapping
	public List<Colaborador> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Colaborador> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Colaborador creado correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public void save(@RequestBody Colaborador colaborador) {
		  servicio.save(colaborador);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Colaborador update(@PathVariable String id, @RequestBody Colaborador colaborador) {	
		Optional<Colaborador> op = servicio.findById(id);
		
		Colaborador colaboradorUpdate = new Colaborador();
		if (!op.isEmpty()) {			
			colaboradorUpdate = op.get();
			
			colaboradorUpdate= colaborador;			
			colaboradorUpdate.setId(id);
			colaboradorUpdate.setTelefono(colaborador.getTelefono());
			colaboradorUpdate.setCargo_id(colaborador.getCargo_id());
			colaboradorUpdate.setCedula(colaborador.getCedula());
			colaboradorUpdate.setMail(colaborador.getMail());
			colaboradorUpdate.setArea_id(colaborador.getArea_id());
			colaboradorUpdate.setNombres(colaborador.getNombres());
			servicio.save(colaboradorUpdate);
				
	  }
       return colaborador;
    }

	


	
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	


}
