package service;

import java.util.List;
import java.util.stream.Collectors;

import model.Pagina;

public class BuscadorService {
	List<Pagina> paginas=List.of(new Pagina("http://www.casadellibro.es", "libros","Libros y más cosas"),
			new Pagina("http://www.gamers.es", "juegos","Todo sobre video juegos"),
			new Pagina("http://www.computerall.es", "informática","Ordenadores al mejor precio"),
			new Pagina("http://www.fnac.es", "libros","Bienvenido al mundo del ocio y la cultura"),
			new Pagina("http://www.books.es", "libros","Entra en el mundo del libro"),
			new Pagina("http://www.pcnew.es", "informática","El paraiso del PC"));
	
	public List<Pagina> buscarPaginas(String tema){
		return paginas.stream()
				.filter(p->p.getTematica().equals(tema)) //Stream<Pagina>
				.collect(Collectors.toList()); //List<Pagina>
				
	}
}
