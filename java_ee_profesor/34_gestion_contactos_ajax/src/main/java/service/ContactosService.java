package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

public class ContactosService {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String cadenaCon="jdbc:mysql://localhost:3307/ejemplobd";
	private static final String user="root";
	private static final String pwd="root";
	static {
		try {
			Class.forName(driver);
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean altaContacto(Contacto contacto) {
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){			
			String sql="insert into contactos(nombre,email,edad) ";
			/*sql+="values('"+contacto.getNombre()+"','"+contacto.getEmail()+"',"+contacto.getEdad()+")";
			Statement st=con.createStatement();
			st.execute(sql);
			return true;*/
			sql+="values(?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, contacto.getNombre());
			st.setString(2, contacto.getEmail());
			st.setInt(3, contacto.getEdad());
			st.execute();
			return true;
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public boolean eliminarContacto(String nombre) {
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){			
			String sql="delete from contactos where nombre=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, nombre);
			st.execute();
			return true;
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public List<Contacto> contactos(){
		List<Contacto> lista=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaCon, user, pwd);){			
			String sql="select * from contactos";
			PreparedStatement st=con.prepareStatement(sql);			
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				lista.add(new Contacto(rs.getInt("idContacto"),
										rs.getString("nombre"),
										rs.getString("email"),
										rs.getInt("edad")));
			}
			return lista;			
		}		
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
