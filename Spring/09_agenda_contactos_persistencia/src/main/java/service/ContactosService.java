package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	boolean altaContacto(Contacto contacto);

	boolean eliminarContacto(String nombre);
	boolean eliminarContacto(int idContacto);

	List<Contacto> contactos();
	
	//devuelve lista de contactos cuya edad sea inferior al valor recibido
	List<Contacto> contactosEdadesMax(int edad);
	//devuelve el contacto con el email indicado
	Contacto contactoEmail(String email);
	//actualiza el contacto con el nuevo
	void actualizaEmail(int idContacto, String email);

}