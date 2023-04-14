package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libro;
import model.Tema;

public class LibrosService {
	private static final String cadenaConexion="jdbc:mysql://localhost:3307/libros";
	private static final String user="root";
	private static final String pwd="root";
	private static final String driver="com.mysql.cj.jdbc.Driver";
	
	static {
		try {
			//1. Carga del driver
			Class.forName(driver);
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace(); //mostrar traza error
		}
	}
	
	//método que devuelve un ArrayList con todos los temas
	public List<Tema> obtenerTemas(){
		List<Tema> temas=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);) {			
			String sql="select * from temas";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Tema tema=new Tema(rs.getInt("idTema"),rs.getString("tema"));
				temas.add(tema);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return temas;
	}
	//para cuando se elija la opci�n -Todos-
	public List<Libro> recuperarLibros(){
    	List<Libro> lista=new ArrayList<> ();
    	try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);  ) {			                     
        	String sql="select * from libros";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista; 
    }
	//para el resto de opciones
	public List<Libro> recuperarLibros(int idTema){
    	List<Libro> lista=new ArrayList<> ();
    	try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);) {			                      
        	String sql="select * from libros where idTema=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, idTema);
            ResultSet rs=st.executeQuery();            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista; 
    }
	
	public Libro buscarLibroPorIsbn(int isbn){
    	Libro libro=null;
    	try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);) {			                      
        	String sql="select * from libros where isbn=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, isbn);
            ResultSet rs=st.executeQuery();            
            if(rs.next()){
                libro=new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema"));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return libro; 
    }
	
}
