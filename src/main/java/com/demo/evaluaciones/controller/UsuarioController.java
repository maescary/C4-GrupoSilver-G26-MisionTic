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

import com.demo.evaluaciones.model.Usuario;
import com.demo.evaluaciones.serviceInterface.UsuarioServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServiceInterface servicio;
	
	
	@GetMapping
	public List<Usuario> all() {
		return servicio.all();
	}
	
	@GetMapping("{id}")
	public Optional<Usuario> show(@PathVariable String id) {
		return servicio.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED, reason ="Usuario creado correctamente!" )
	@RequestMapping(method =  RequestMethod.POST, consumes="application/JSON")
	public void save(@RequestBody Usuario user) {
		  servicio.save(user);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Usuario update(@PathVariable String id, @RequestBody Usuario user) {	
		Optional<Usuario> op = servicio.findById(id);
		
		Usuario usuarioUpdate = new Usuario();
		if (!op.isEmpty()) {			
			usuarioUpdate = op.get();
			
			usuarioUpdate= user;			
			usuarioUpdate.setId(id);
			usuarioUpdate.setEstado(user.isEstado());
			usuarioUpdate.setPassword(user.getPassword());
			usuarioUpdate.setRol_id(user.getRol_id());
			usuarioUpdate.setUsername(user.getUsername());
			
			servicio.save(usuarioUpdate);
				
	  }
       return user;
    }

	


	
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		servicio.delete(id);
	}	


}