package com.demo.evaluaciones.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("roles")
public class Rol {
	
	@Id
	private String id;
	
	
	private String rol_name;
	
	@DBRef
	private List<Permiso> permisos;
	
	private boolean estado;

}


