package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ContactosDao;
import model.Contacto;
@Service
public class ContactosServiceImpl implements ContactosService {
	@Autowired
	ContactosDao contactosDao;
	
	
	@Override
	public boolean altaContacto(Contacto contacto) {
		//verificamos que no exista antes de añadirlo
		Optional<Contacto> c=contactosDao.findById(contacto.getIdContacto());
		if(c.isEmpty()) {
			contactosDao.save(contacto);
			return true;
		}
		return false;
	}	
	@Override
	public boolean eliminarContacto(int idContacto) {
		//buscamos contacto con ese id
		Optional<Contacto> contacto=contactosDao.findById(idContacto);
		if(contacto.isPresent()) {
			contactosDao.deleteById(idContacto);
			return true;
		}
		return false;
	}	
	@Override
	public boolean eliminarContacto(String nombre) {
		Contacto contacto=contactosDao.findByNombre(nombre);
		if(contacto!=null) {
			contactosDao.deleteByNombre(nombre);
			return true;
		}
		return false;
	}
	@Override
	public List<Contacto> contactos() {
		return contactosDao.findAll();
	}	
}
