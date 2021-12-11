package com.demo.evaluaciones.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("evaluaciones")
public class Evaluacion {
	
	
	@Id
	private String id;
	
	
	private Colaborador colaborador_id;
	
	private Colaborador evaluador_id;
	
	private String fecha_inicio;
	
	private String fecha_fin;
	
	private boolean estado;
	
	private double resultado;
	
	private List<Cuestionario> cuestionarios;
}
