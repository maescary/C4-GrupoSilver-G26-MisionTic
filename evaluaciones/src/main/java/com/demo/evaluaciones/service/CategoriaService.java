package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Categoria;
import com.demo.evaluaciones.repository.CategoriaRepository;
import com.demo.evaluaciones.serviceInterface.CategoriaServiceInterface;

@Service
public class CategoriaService implements CategoriaServiceInterface {

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public List<Categoria> all() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Categoria> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Categoria save(Categoria categoria) {
		
		return repository.save(categoria);
	}

	@Override
	public void delete(String id) {
		
		repository.deleteById(id);
		
	}

}
