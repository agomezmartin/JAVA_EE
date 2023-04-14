package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Cliente;
@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	JdbcTemplate template;	
	@Override
	public boolean altaCliente(Cliente cliente) {
	
		String sql = "insert into clientes(usuario, password,email,telefono) ";			
		sql+="values(?,?,?,?)";
		try {
			template.update(sql,cliente.getUsuario(),cliente.getPassword(),cliente.getEmail(),cliente.getTelefono());
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean validarCliente(String usuario, String passwd) {
		String sql = "SELECT * FROM clientes WHERE usuario = ? AND password = ? ";	
		List<Cliente> clientes=template.query(sql, (rs,f)->
			new Cliente(rs.getInt("idCliente"),
					rs.getString("usuario"),
					rs.getString("password"),
					rs.getString("email"),
					rs.getInt("telefono")), usuario,passwd);
		return clientes.size()>0;
		
	}

	
	

}
