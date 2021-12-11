package com.demo.evaluaciones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("categorias-preguntas")
public class Categoria {
	
	@Id
	private String id;
	
	@Field("descripcion")
	private String descripcion;
	

}