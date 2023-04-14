package service;

import java.util.List;

import model.Alumno;

public interface CursosService {
	
	public List<Alumno> mostrarAlumnos(String curso);

}
