package com.demo.evaluaciones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Usuario {
	
	@Id
	private String id;
	
	@Field("username")
	private String  username;
	
	@Field("password")
	private String password;
	
	@Field("estado")
	private boolean estado;
	
	@DBRef
	private Rol rol_id;
	

}
