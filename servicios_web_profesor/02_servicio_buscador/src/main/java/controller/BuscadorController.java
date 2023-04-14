package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Pagina;
import service.BuscadorService;

@RestController
public class BuscadorController {
	
	@Autowired
	BuscadorService service;

	@GetMapping(value="buscar", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> todas(){
		return service.todas();
	}

	@GetMapping(value="buscar/{tematica}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pagina> buscadir(@PathVariable("tematica") String tematica){
		return service.buscar(tematica);
	}
	
	// petición POST para DAR DE ALTA una página
	@PostMapping(value="alta", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Pagina nuevaPagina(@RequestBody Pagina pagina) {
		return service.nuevaPagina(pagina);
	}

	// petición POST para ACTUALIZAR una página
	@PutMapping(value="actualizar", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Pagina actualizarPagina(@RequestBody Pagina pagina) {
		return service.actualizarPagina(pagina);
	}

	// petición POST para ELIMINAR una página
	@DeleteMapping(value="eliminar", produces=MediaType.APPLICATION_JSON_VALUE)
	public Pagina eliminarPagina(@RequestParam("url") String direccion) {
		return service.eliminarPagina(direccion);
	}

}