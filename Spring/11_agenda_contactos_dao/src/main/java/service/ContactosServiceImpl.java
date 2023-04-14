package service;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ContactosDao;
import model.Contacto;
@Service
public class ContactosServiceImpl implements ContactosService {
	@Autowired
	ContactosDao contactosDao;
	
	
	@Override
	public boolean altaContacto(Contacto contacto) {
		//verificamos que no exista antes de añadirlo
		Contacto c=contactosDao.findByIdContacto(contacto.getIdContacto());
		if(c==null) {
			contactosDao.save(contacto);
			return true;
		}
		return false;
	}	
	@Override
	public boolean eliminarContacto(int idContacto) {
		//buscamos contacto con ese id
		Contacto contacto=contactosDao.findByIdContacto(idContacto);
		if(contacto!=null) {
			contactosDao.deleteByIdContacto(idContacto);
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
