package model;

/*
 * 1.- Añadir curso
 * 2.- Buscar curso
 * 3.- Cursos por tematica
 * 4.- Precio medio por temática
 * 5.- Curso mayor duración
 * 6.- Salir
 * 
 */

// encapsulación de datos

public class Curso {
	
	private String nombre;
	private String tematica;
	private int duracion;
	private double precio;
	
	// constructor vacio
	public Curso() {

	}
	
	// constructor por parámetros
	public Curso(String nombre, String tematica, int duracion, double precio) {
		this.nombre = nombre;
		this.tematica = tematica;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	// setters y getters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}