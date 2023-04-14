package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import model.Pais;
import service.BuscadorService;

public class PaisesController {
	
	@Autowired
	BuscadorService service;
	
	@GetMapping(value="paises", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> paises(){
		
		return service.continentes();
		
	}
	
	@GetMapping(value="paises/{continent}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisContinent(@PathVariable("continent") String continent){
		
		return service.paisContinent(continent);
	}
	
	
}