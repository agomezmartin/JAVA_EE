package service;

import java.util.List;

import model.Pais;

public interface BuscadorService {
	
	List<String> continentes();
	List<Pais> paisContinent(String continent);
	
}