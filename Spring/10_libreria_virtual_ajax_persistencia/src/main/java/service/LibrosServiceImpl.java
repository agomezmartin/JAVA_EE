package service;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import model.Libro;
import model.Tema;
@Service
public class LibrosServiceImpl implements LibrosService {
	@PersistenceContext
	EntityManager eManager;		
	
	@Override
	public List<Tema> obtenerTemas(){
		String jpql="select t from Tema t";
		return eManager.createQuery(jpql,Tema.class).getResultList();
	}
	//para cuando se elija la opci�n -Todos-
	@Override
	public List<Libro> recuperarLibros(){  	
    	String jpql="select l from Libro l";
    	return eManager.createQuery(jpql,Libro.class).getResultList();
    }
	//para el resto de opciones
	@Override
	public List<Libro> recuperarLibros(int idTema){   	
    	String jpql="select l from Libro l where l.idTema=?1";
    	TypedQuery<Libro> query=eManager.createQuery(jpql,Libro.class);
    	query.setParameter(1, idTema);
    	return query.getResultList();
    }
	
	@Override
	public Libro buscarLibroPorIsbn(int isbn){
		String jpql="select l from Libro l where l.isbn=?1";
    	TypedQuery<Libro> query=eManager.createQuery(jpql,Libro.class);
    	query.setParameter(1, isbn);
    	List<Libro> libros=query.getResultList();
    	return libros.size()>0?libros.get(0):null;
    }
	
}
