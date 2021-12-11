package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Usuario;
import com.demo.evaluaciones.repository.UsuarioRepository;
import com.demo.evaluaciones.serviceInterface.UsuarioServiceInterface;

@Service
public class UsuarioService implements UsuarioServiceInterface{

	
	@Autowired
	private UsuarioRepository  repository;
	
	
	@Override
	public List<Usuario> all() {
	
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Usuario save(Usuario user) {
		
		return repository.save(user);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
		
	}
	
}