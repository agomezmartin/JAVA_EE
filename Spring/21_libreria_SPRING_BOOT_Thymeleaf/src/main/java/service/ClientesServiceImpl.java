package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import model.Cliente;
@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	ClientesDao clientesDao;
	@Override
	public boolean altaCliente(Cliente cliente) {
		if(clientesDao.findById(cliente.getIdCliente()).isEmpty()) {
			clientesDao.save(cliente);
			return true;
		}
		return false;
		
		
	}
	@Override
	public boolean validarCliente(String usuario, String passwd) {
		return clientesDao.findByUsuarioAndPassword(usuario, passwd)!=null;
		
	}

	
	

}
