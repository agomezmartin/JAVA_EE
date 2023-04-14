package service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import model.Tema;
@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	TemasDao temasDao;
	@Autowired
	LibrosDao librosDao;
	
	@Override
	public List<Tema> obtenerTemas(){
		return temasDao.findAll();
	}
	//para cuando se elija la opci�n -Todos-
	@Override
	public List<Libro> recuperarLibros(){  	
    	return librosDao.findAll();
    }
	//para el resto de opciones
	@Override
	public List<Libro> recuperarLibros(int idTema){   	
    	return librosDao.findByIdTema(idTema);
    }
	
	@Override
	public Libro buscarLibroPorIsbn(int isbn){
		return librosDao.findById(isbn).orElse(null);
    }
	
}
