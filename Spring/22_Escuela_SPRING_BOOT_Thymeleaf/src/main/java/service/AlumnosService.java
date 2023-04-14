package service;

import java.util.List;

import model.Alumno;

public interface AlumnosService {
	
	public Alumno altaAlumno(Alumno alumno);
	public void eliminarAlumno(String dni);
	public void cambiarCurso(String dni, int idCurso);
	public List<Alumno> buscarAlumno(int idCurso);

}
