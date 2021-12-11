
package com.demo.evaluaciones.serviceInterface;


import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Colaborador;




public interface ColaboradorServiceInterface {

	public List<Colaborador> all();

	public Optional<Colaborador> findById(String id);
	
	public Colaborador save(Colaborador colaborador);
	
	public void delete(String id);
	
	
	
}
