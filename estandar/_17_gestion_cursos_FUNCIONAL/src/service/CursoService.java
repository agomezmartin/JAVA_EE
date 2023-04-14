package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import model.Curso;

/*
 * 
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
	public void agregarCurso(Curso curso) {
		
		cursos.add(curso);

	}

	// método de BUSCAR CURSO: recibe el nombre del curso y devuelve sus datos
	public Curso buscarCurso(String nombre) {
		
		return
				cursos.stream()
				.filter(c -> c.getNombre().equals(nombre)) // devuelve un Stream<Curso>
				.findFirst() // Optional<Curso>
				.orElse(null) // se devuelve el resultado y se muestra NULL en caso de que el STREAM llegue vacío
				;

		}
	
	// método de BUSCAR CURSO POR TEMÁTICA: recibe una temática y devuelve la lista de cursos con esa temática
	public List<Curso> cursosPorTematica(String tematica) {
		
		return
				cursos.stream()
				.filter(c -> c.getTematica().equals(tematica)) // se filtra por TEMÁTICA
				.collect(Collectors.toList()); // el resultado se CONVIERTE a Lista
	}
	
	// método de PRECIO MEDIO DE CURSO POR TEMÁTICA: 
	public double precioMedioTematica(String tematica) {
		
		return 
				cursos.stream()
				.filter(c -> c.getTematica().equals(tematica))
				.mapToDouble(c -> c.getPrecio())
				.average() // Optional
				.orElse(0) // Devolver 0 en caso de llegar vacío
				;

	}
	
	// método CURSO MAYOR DURACIÓN
	public Curso cursoDuracionMax() {
		
		return 
				cursos.stream()
				.max(Comparator.comparingInt(c -> c.getDuracion())) // Optioinal
				.orElse(null)
				;
		}
	}