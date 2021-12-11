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
@Document("preguntas")
public class Pregunta {

	
	@Id
	private String id;
	
	@DBRef
	private Categoria categoria;
	
	@Field("enunciado")
	private String enunciado;
	
	@DBRef
	private List<Respuesta> opciones_res;
	
	@Field("valor_pregunta")
	private boolean valor_pregunta;
	
}
