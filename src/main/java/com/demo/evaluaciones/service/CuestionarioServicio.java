package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Cuestionario;
import com.demo.evaluaciones.repository.CuestionarioRepositorry;
import com.demo.evaluaciones.serviceInterface.CuestionarioServiceInterface;

@Service
public class CuestionarioServicio implements CuestionarioServiceInterface{

	@Autowired
	private CuestionarioRepositorry repository;
	
	@Override
	public List<Cuestionario> all() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Cuestionario> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Cuestionario save(Cuestionario cuestionario) {
	
		return repository.save(cuestionario);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);		
	}

}
