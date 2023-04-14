package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Cliente;

public class ClientesService {
	static DataSource ds;
	static{
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		}catch(NamingException ex) {
			ex.printStackTrace();
		}
	}
	public boolean altaCliente(Cliente cliente) {
		// forma adecuada con try con recursos (no hay que poner con.close() porque la cierra automáticamente)
		try (Connection con = ds.getConnection();) {
			String sql = "insert into clientes(usuario, password,email,telefono) ";			
			sql+="values(?,?,?,?)";
			
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, cliente.getUsuario());
			st.setString(2, cliente.getPassword());
			st.setString(3, cliente.getEmail());
			st.setInt(4, cliente.getTelefono());
			st.execute();
			
//			System.out.println("Contacto añadido");	// TRAZA
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean validarCliente(String usuario, String passwd) {
		try (Connection con = ds.getConnection();) {
			String sql = "SELECT * FROM clientes WHERE usuario = ? AND password = ? ";						
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, usuario);
			st.setString(2, passwd);
			ResultSet rs = st.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	
	

}
