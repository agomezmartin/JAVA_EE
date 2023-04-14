package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import model.Curso;

/*
 * 1.- Añadir curso
 * 2.- Buscar curso
 * 3.- Cursos por tematica
 * 4.- Precio medio por temática
 * 5.- Curso mayor duración
 * 6.- Salir
 * 
 */

public class CursoService {
	
	// variable colección de tipo LISTA en la que se gardan los cursos
	List<Curso> cursos = new ArrayList<>();

	// método de AÑADIR CURSO: recibe un curso y lo guarda
	public boolean agregarCurso(Curso curso) {
		
		// recorrer CURSOS
		Collection<Curso> aux = cursos;
		for (Curso c:aux) {

			if (!cursos.equals(curso)) {

				cursos.add(curso);
				return true;
			
				}
			return false;
		}
	}

	// método de BUSCAR CURSO: recbe el nombre del curso y devuelve sus datos
	public Curso buscarCurso(String nombre) {
		
		for(Curso curso:cursos) {
			if(curso.getNombre().equals(nombre)) {
				
				return curso;
				
			} // cierre IF
			
			return null;
			
		} // cierre FOR
		
		return null; // se devuelve NULL en caso de NO encontrar un curso con ese nombre
	}
	
	// método de BUSCAR CURSO POR TEMÁTICA: recibe una temática y devuelve la lista de cursos con esa temática
	public List<Curso> cursosPorTematica(String tematica) {
		
		List<Curso> aux = new ArrayList<>();
		for(Curso curso:cursos) {
			if(curso.getTematica().equals(tematica)) {// si coincide la tematica, se guarda el curso en la lista auxiliar
				aux.add(curso);
			}
		}
		return aux;
	}
	
	// método de PRECIO MEDIO DE CURSO POR TEMÁTICA: 
	public double precioMedioTematica(String tematica) {

		double suma = 0.0;
		int contador = 0;
		
		for(Curso curso:cursos) {
			if(curso.getTematica().equals(tematica)) {
				suma+=curso.getPrecio();
				contador++;
			}
		}
		
		return suma/contador;
		
	}
	
	// método CURSO MAYOR DURACIÓN
	public Curso cursoDuracionMax() {
		
		Curso cursoMayor = null;
		int duracion = 0;
		
		for(Curso curso:cursos) {
			if(curso.getDuracion() > duracion) { // se comprueba la duración
				
				cursoMayor = curso;
				
			} // cierre IF
		} // cierre FOR
		
		return cursoMayor;
		
	}

}