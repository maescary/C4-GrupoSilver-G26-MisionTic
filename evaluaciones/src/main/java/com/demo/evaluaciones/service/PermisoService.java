package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Permiso;
import com.demo.evaluaciones.repository.PermisoRepository;
import com.demo.evaluaciones.serviceInterface.PermisoServiceInterface;

@Service
public class PermisoService implements PermisoServiceInterface {


	@Autowired
	private PermisoRepository  repository;
	
	
	@Override
	public List<Permiso> all() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Permiso> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Permiso save(Permiso permiso) {
		
		return repository.save(permiso);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
		
	}

}
