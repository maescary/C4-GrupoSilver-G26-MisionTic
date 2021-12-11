package com.demo.evaluaciones.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.demo.evaluaciones.model.Usuario;

public interface UsuarioServiceInterface  {
	
	public List<Usuario> all();

	public Optional<Usuario> findById(String id);
	
	public Usuario save(Usuario user);
	
	public void delete(String id);

}
