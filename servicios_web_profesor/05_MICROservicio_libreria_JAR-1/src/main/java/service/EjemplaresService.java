package service;

import java.util.List;

import model.Ejemplar;

public interface EjemplaresService {
	
	List<Ejemplar> ejemplarPrecio(double min, double max);
	List<String> temas();
	List<Ejemplar> ejemplaresTemas(String tema);
	

}
