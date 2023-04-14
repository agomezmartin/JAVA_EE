package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	boolean altaContacto(Contacto contacto);

	boolean eliminarContacto(String nombre);
	boolean eliminarContacto(int idContacto);

	List<Contacto> contactos();
	
	
}