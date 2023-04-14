package service;

import java.util.List;

import model.Libro;
import model.Tema;

public interface LibrosService {

	//método que devuelve un ArrayList con todos los temas
	List<Tema> obtenerTemas();

	//para cuando se elija la opci�n -Todos-
	List<Libro> recuperarLibros();

	//para el resto de opciones
	List<Libro> recuperarLibros(int idTema);

	Libro buscarLibroPorIsbn(int isbn);

}