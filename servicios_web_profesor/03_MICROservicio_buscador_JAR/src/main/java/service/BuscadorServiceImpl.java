package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Pagina;

/*
 * Video: Sesión 28. 11:30
 */

@Service
public class BuscadorServiceImpl implements BuscadorService {
	static List<Pagina> paginas=new ArrayList<>(List.of(new Pagina("http://www.casadellibro.es", "libros","Libros y más cosas"),
			new Pagina("http://www.gamers.es", "juegos","Todo sobre video juegos"),
			new Pagina("http://www.computerall.es", "informática","Ordenadores al mejor precio"),
			new Pagina("http://www.fnac.es", "libros","Bienvenido al mundo del ocio y la cultura"),
			new Pagina("http://www.books.es", "libros","Entra en el mundo del libro"),
			new Pagina("http://www.pcnew.es", "informática","El paraiso del PC")));
	
	@Override
	public List<Pagina> buscar(String tematica) {
		return paginas.stream()
				.filter(p->p.getTematica().equals(tematica)) //Stream<Pagina>
				.collect(Collectors.toList()); //List<Pagina>
	}
	
	@Override
	public void altaPagina(Pagina pagina) {
		paginas.add(pagina);
		
	}
	
	@Override
	public List<Pagina> todas() {

		return paginas;
	}
	
	@Override
	public Pagina nuevaPagina(Pagina pagina) {

		// si la página NO existe
		if(paginaPorDireccion(pagina.getDireccion())==null) {

			// se añade la página
			paginas.add(pagina);
			return pagina;
		}

		// si no, null
		return null;
	}

	@Override
	public Pagina eliminarPagina(String direccion) {
		
		Pagina pagina = paginaPorDireccion(direccion);
		
		// si existe la página, se elimina
		if(pagina!=null) {
			paginas.removeIf(p -> p.getDireccion().equals(direccion));
			return pagina;			
		}
		// si no, null
		return null;

	}

	@Override
	public Pagina actualizarPagina(Pagina pagina) {
		
		Pagina existente = paginaPorDireccion(pagina.getDireccion());
		
		// si existe la página, se modifican el resto de datos
		if(existente!=null) {

			existente.setDescripcion(pagina.getDescripcion());
			existente.setTematica(pagina.getTematica());

			return existente;			
		}

		// si no, null
		return null;

	}
	
	// método que busca una página
	private Pagina paginaPorDireccion(String direcion) {
		
		return paginas.stream()
		.filter(p -> p.getDireccion().equals(direcion)) // Devuelve Stream)
				.findFirst() // Devuelve un Optional <Pagina>
				.orElse(null);
	}

}