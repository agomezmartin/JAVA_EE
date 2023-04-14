package service;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import model.Libro;
import model.Tema;
@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	JdbcTemplate template;	
	//método que devuelve un ArrayList con todos los temas
	
	RowMapper<Libro> row=(rs,f)->new Libro(rs.getInt("isbn"),
            rs.getString("titulo"),
            rs.getString("autor"),
            rs.getDouble("precio"),
            rs.getInt("paginas"),
            rs.getInt("idTema"));
	@Override
	public List<Tema> obtenerTemas(){
		String sql="select * from temas";
		return template.query(sql, (rs,f)->new Tema(rs.getInt("idTema"),rs.getString("tema")));
	}
	//para cuando se elija la opci�n -Todos-
	@Override
	public List<Libro> recuperarLibros(){  	
    	String sql="select * from libros";
        return template.query(sql, row);
    }
	//para el resto de opciones
	@Override
	public List<Libro> recuperarLibros(int idTema){   	
    	String sql="select * from libros where idTema=?";
    	return template.query(sql, row,idTema);
    }
	
	@Override
	public Libro buscarLibroPorIsbn(int isbn){
    	String sql="select * from libros where isbn=?";
    	List<Libro> libros= template.query(sql, row,isbn); 
    	return libros.size()>0?libros.get(0):null;
    }
	
}
