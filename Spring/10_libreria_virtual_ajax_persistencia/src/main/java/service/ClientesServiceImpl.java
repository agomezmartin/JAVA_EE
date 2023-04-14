package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import model.Cliente;
@Service
public class ClientesServiceImpl implements ClientesService {
	@PersistenceContext
	EntityManager eManager;	
	@Override
	public boolean altaCliente(Cliente cliente) {
	
		Cliente cl=eManager.find(Cliente.class, cliente.getIdCliente());
		if(cl==null) {
			eManager.persist(cliente);
			return true;
		}
		return false;
		
	}
	@Override
	public boolean validarCliente(String usuario, String passwd) {
		String jpql = "SELECT c FROM Cliente c WHERE c.usuario = ?1 AND c.password = ?2";
		TypedQuery<Cliente> query=eManager.createQuery(jpql,Cliente.class);
		query.setParameter(1, usuario);
		query.setParameter(2, passwd);
		List<Cliente> clientes=query.getResultList();
		return clientes.size()>0;
		
	}

	
	

}
