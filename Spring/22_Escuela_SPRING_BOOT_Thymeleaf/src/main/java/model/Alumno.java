package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Alumno {
	
	private String dni;
	private String nombre;
	private int edad;
	private String email;
	private int curso;

}