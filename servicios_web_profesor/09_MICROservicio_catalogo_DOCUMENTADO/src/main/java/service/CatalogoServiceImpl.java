package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import model.Tema;
@Service
public class CatalogoServiceImpl implements CatalogoService {
	
	@Autowired
	LibrosDao librosDao;
	
	@Autowired
	TemasDao temasDao;

	@Override
	public List<Libro> catalogo() {
		return librosDao.findAll();
	}

	@Override
	public Libro buscarLibroPorIsbn(int isbn) {
		return librosDao.findById(isbn).orElse(null);
	}

	@Override
	public Libro eliminarPorIsbn(int isbn) {
		Libro libro=buscarLibroPorIsbn(isbn);
		if(libro!=null) {
			librosDao.deleteById(isbn);
		}
		return libro;
	}

	@Override
	public Libro altaLibro(Libro libro) {
		if(buscarLibroPorIsbn(libro.getIsbn())==null) {
			return librosDao.save(libro);
		}
		return null;
	}

	@Override
	public List<Libro> librosPorTematica(String tema) {
		Tema t=temasDao.findByTema(tema);
		if(t!=null) {
			return librosDao.findByIdTema(t.getIdTema());
		}
		return List.of(); //lista vacía
	}

	@Override
	public void actualizarPrecios(double porcentaje, String tema) {
		/*opción sin query
		List<Libro> libros=librosPorTematica(tema);
		libros.forEach(l->{
			l.setPrecio(l.getPrecio()*((100+porcentaje)/100));
			librosDao.save(l);
		});
		*/
		Tema t=temasDao.findByTema(tema);
		librosDao.updatePrecio(porcentaje, t.getIdTema());
	}

	@Override
	public List<String> temas() {
		
		return temasDao.findAll() // devuelve una Lista<Tema>
				.stream() // crea un Stream<Tema>
				.map(t -> t.getTema()) // Stream<String>
				.collect(Collectors.toList()) // lo convierte a lista
				;
	}

}