package com.demo.evaluaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.evaluaciones.model.Colaborador;
import com.demo.evaluaciones.repository.ColaboradorRepository;
import com.demo.evaluaciones.serviceInterface.ColaboradorServiceInterface;

@Service
public class ColaboradorService  implements ColaboradorServiceInterface{

	@Autowired
	private ColaboradorRepository repositorio;
	
	
	@Override
	public List<Colaborador> all() {
	
		return repositorio.findAll();			
	}

	@Override
	public Optional<Colaborador> findById(String id) {
	
		return repositorio.findById(id);
	}

	@Override
	public Colaborador save(Colaborador colaborador) {
		
		return repositorio.save(colaborador);
		
	}

	@Override
	public void delete(String id) {
		
		
	}


}
