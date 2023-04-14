package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Ejemplar;

@Service
public class EjemplaresServiceImpl implements EjemplaresService {
	
	@Autowired
	RestTemplate template;
	String urlBase = "http://localhost:8000/"; // dirección base del servicio con el que vamos a interaccionar

	// método que muestra el rango de precios
	@Override
	public List<Ejemplar> ejemplarPrecio(double min, double max) {

		Ejemplar[] ejemplar = template.getForObject(urlBase + "catalogo", Ejemplar[].class);
		
		// se convierten los resultados a Stream, se filtran los resultados y se devuelve una lista
		return Arrays.stream(ejemplar) // devuelve un Stream<Ejemplar>
		.filter(e -> e.getPrecio() >= min && e.getPrecio() <= max) // se filtran los resultados
		.collect(Collectors.toList()); // se convierte a LISTA
	}

	@Override
	public List<String> temas() {
		
		return Arrays.asList(template.getForObject(urlBase + "temas", String[].class));
	
	}

	@Override
	public List<Ejemplar> ejemplaresTemas(String tema) {
		
		return Arrays.asList(template.getForObject(urlBase + "catalogo/{tema}", Ejemplar[].class, tema));

	}

}
