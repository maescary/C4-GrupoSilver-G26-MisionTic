package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Area;
import com.demo.evaluaciones.repository.AreaRepository;
import com.demo.evaluaciones.serviceInterface.AreaServiceInterface;

@Service
public class AreaService implements AreaServiceInterface{

	@Autowired
	private AreaRepository repository;

	@Override
	public List<Area> all() {
		return  repository.findAll();
	}

	@Override
	public Optional<Area> findById(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Area save(Area area) {
		
		return repository.save(area);
	}

	@Override
	public void delete(String id) {
		
		repository.deleteById(id);
		
	}
}
