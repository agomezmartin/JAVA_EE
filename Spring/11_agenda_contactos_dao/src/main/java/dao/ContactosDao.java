package dao;

import java.util.List;

import model.Contacto;

public interface ContactosDao {
	public void save(Contacto contacto);
	public Contacto findByIdContacto(int idContacto);
	public Contacto findByNombre(String nombre);
	public List<Contacto> findAll();
	public void deleteByNombre(String nombre);
	public void deleteByIdContacto(int idContacto);
}
