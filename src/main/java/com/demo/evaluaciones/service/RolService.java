package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Rol;
import com.demo.evaluaciones.repository.RolRepository;
import com.demo.evaluaciones.serviceInterface.RolServiceInterface;


@Service
public class RolService implements RolServiceInterface{

	
	@Autowired
	private RolRepository  repository;
	
	
	@Override
	public List<Rol> all() {
	
		return repository.findAll();
	}

	@Override
	public Optional<Rol> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Rol save(Rol rol) {
		
		return repository.save(rol);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
		
	}
	

}
