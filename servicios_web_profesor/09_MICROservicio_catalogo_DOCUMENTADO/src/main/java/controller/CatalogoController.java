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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Libro;
import service.CatalogoService;
@RestController
public class CatalogoController {
	@Autowired
	CatalogoService catalogoService;
	
	/* Las anotaciones @ApiOperation y @ApParam sirven para DOCUMENTAR*/
	@ApiOperation(value="Devuelve los libros por temática")
	@GetMapping(value="catalogo/{tema}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> verTema(@PathVariable("tema") String tema) {			
		return catalogoService.librosPorTematica(tema);	
	}	

	/* Las anotaciones @ApiOperation y @ApParam sirven para DOCUMENTAR*/
	@ApiOperation(value="Elimina libro por ISBN")
	@DeleteMapping(value="elimina/{isbn}",produces=MediaType.APPLICATION_JSON_VALUE)
	public  Libro elimina(@ApiParam(value="ISBN del libro a eliminar") @PathVariable("isbn") int isbn) {		
		return catalogoService.eliminarPorIsbn(isbn);
	}
	
	@PostMapping(value="alta",consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public Libro alta(@RequestBody Libro libro) {		
		return catalogoService.altaLibro(libro);
	}
	
	@GetMapping(value="buscar/{isbn}",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Libro buscaIsbn(@PathVariable("isbn") int isbn) {		
		return catalogoService.buscarLibroPorIsbn(isbn);
	}
	
	@GetMapping(value="catalogo",produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<Libro> verTodos() {				
		return catalogoService.catalogo();
	}

	@GetMapping(value="temas",produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<String> verTemas() {				
		return catalogoService.temas();
	}
	
	@PutMapping(value="actualizar/{porcentaje}/{tema}",produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<Libro> modificaPrecio(@PathVariable("porcentaje") double porc,
			@PathVariable("tema") String tema) {	
		catalogoService.actualizarPrecios(porc,tema);
		return catalogoService.librosPorTematica(tema);		
	}
}