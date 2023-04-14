package snippet;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import model.Pagina;

public class Snippet {
	// petición POST para ACTUALIZAR una página
	@PutMapping(value="actualizar", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Pagina actualizarPagina(@RequestBody Pagina pagina) {
		return service.actualizarPagina(pagina);
	}
	
	
}

