package service;

import model.Cliente;

public interface ClientesService {

	boolean altaCliente(Cliente cliente);

	boolean validarCliente(String usuario, String passwd);

}