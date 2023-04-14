package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pais;

@Service
public class BuscadorServiceImpl implements BuscadorService {
	
	@Autowired
	RestTemplate template;
	String urlBase = "https://restcountries.com/v2/all";

	
	Pais[] paises;

	@PostConstruct
	public void init() {
		paises = template.getForObject(urlBase, Pais[].class);
	}

	@Override
	public List<String> continentes() {

		return Arrays.stream(paises)
				.map(p->p.getContinent())
				.distinct()
				.collect(Collectors.toList());

	}

	@Override
	public List<Pais> paisContinent(String continent) {

		return Arrays.stream(paises) // devuelve un STREAM,se filtran los resultados y se devuelve una lista
				.filter(p -> p.getContinent().equals(continent))
				.collect(Collectors.toList()); // se convierte a LISTA
	}

}