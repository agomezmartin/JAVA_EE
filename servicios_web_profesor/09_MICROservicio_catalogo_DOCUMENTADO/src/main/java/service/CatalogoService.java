package service;

import java.util.List;

import model.Libro;

public interface CatalogoService {
	List<Libro> catalogo();
	Libro buscarLibroPorIsbn(int isbn);
	Libro eliminarPorIsbn(int isbn);
	Libro altaLibro(Libro libro);
	List<Libro> librosPorTematica(String tema);
	List<String> temas();
	
	void actualizarPrecios(double porcentaje, String tema);
}
