package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Ejemplar;
import service.EjemplaresService;

@CrossOrigin("*")
@RestController
public class EjemplaresController {
	
	@Autowired
	EjemplaresService service;
	
	@GetMapping(value="ejemplares/{min}/{max}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Ejemplar> precios(@PathVariable("min") double min, @PathVariable("max") double max){
		
		return service.ejemplarPrecio(min, max);
	}
	
	@GetMapping(value="ejemplares/{tema}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Ejemplar> tematica(@PathVariable("tema") String tema){
		return service.ejemplaresTemas(tema);
	}
	@GetMapping(value="temas",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> temas(){
		return service.temas();
	}

}