package com.demo.evaluaciones.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("cuestionarios") 
public class Cuestionario {
	
	@Id
	private String id;
	
	@Field("nombre")
	private String nombre;
	
	@DBRef
	private List<Pregunta> seccion_preguntas;
	
	@Field("total_seccion")
	private double total_seccion;
	
	@Field("estado")
	private boolean estado;

	
}
