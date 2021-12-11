package com.demo.evaluaciones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("colaboradores")
public class Colaborador {
	
	@Id
	private String id;
	
	@Field("codigo")
	private String codigo;
	
	@Field("cedula")
	private String cedula;
	
	@Field("nombres")
	private String nombres;
	
	
	
	@Field("mail")
	private String mail;
	
	@Field("telefono")
	private String telefono;
	
	@DBRef
	private Cargo cargo_id;
	
	@DBRef
	private Area area_id;
	
	
	@Field("estado")
	private boolean estado;

}
