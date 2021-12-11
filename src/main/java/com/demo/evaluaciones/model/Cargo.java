package com.demo.evaluaciones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("cargos")
public class Cargo {
	
	@Id
	private String id;
	
	@Field("descripcion")
	private String descripcion;
	
	@Field("codigo")
	private String codigo;
	

}
