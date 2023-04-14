package model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Curso {
	
	private String idCurso;
	private String denominacion;
	private int duracion;
	private int precio;
	private Date fechainicio;

}