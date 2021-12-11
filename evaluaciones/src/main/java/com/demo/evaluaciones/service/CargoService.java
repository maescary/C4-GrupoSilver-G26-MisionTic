package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Cargo;
import com.demo.evaluaciones.repository.CargoRepository;
import com.demo.evaluaciones.serviceInterface.CargoServiceInterface;

@Service
public class CargoService implements CargoServiceInterface{

	@Autowired
	private CargoRepository repository;

	@Override
	public List<Cargo> all() {
		
		return  repository.findAll();
	}

	@Override
	public Optional<Cargo> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Cargo save(Cargo cargo) {
		
		return repository.save(cargo);
	}

	@Override
	public void delete(String id) {
		
		repository.deleteById(id);
		
	}
}