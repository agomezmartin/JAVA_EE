package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Contacto;
@Service
public class ContactosServiceImpl implements ContactosService {
	//utilizamos el API JPA
	@PersistenceContext
	EntityManager eManager;
	@Transactional
	@Override
	public boolean altaContacto(Contacto contacto) {
		//verificamos que no exista antes de añadirlo
		Contacto c=eManager.find(Contacto.class, contacto.getIdContacto());
		if(c==null) {
			eManager.persist(contacto);
			return true;
		}
		return false;
	}
	@Transactional
	@Override
	public boolean eliminarContacto(int idContacto) {
		//buscamos contacto con ese id
		Contacto contacto=eManager.find(Contacto.class, idContacto);
		if(contacto!=null) {
			eManager.remove(contacto);
			return true;
		}
		return false;
	}
	@Transactional
	@Override
	public boolean eliminarContacto(String nombre) {
		//String jpql="delete from Contacto c where c.nombre='"+nombre+"'";
		String jpql="delete from Contacto c where c.nombre=?1";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, nombre);
		int res=query.executeUpdate();
		return res>0;
	}

	@Override
	public List<Contacto> contactos() {
		String jpql="select c from Contacto c";
		Query query=eManager.createQuery(jpql);
		return (List<Contacto>)query.getResultList();
	}
	
	
	public List<Contacto> contactosEdadesMax(int edad) {
		String jpql = "select c from Contacto c where c.edad < ?1";
		TypedQuery<Contacto> query = eManager.createQuery(jpql,Contacto.class);
		query.setParameter(1, edad);
		return query.getResultList();
	}
	@Override
	public Contacto contactoEmail(String email) {
		String jpql="select c from Contacto c where c.email = ?1";
		TypedQuery<Contacto> query=eManager.createQuery(jpql,Contacto.class);
		query.setParameter(1, email);
		List<Contacto> contactos= query.getResultList();
		return contactos.size()>0?contactos.get(0):null;
	}

	@Transactional
	@Override
	public void actualizaEmail(int idContacto, String email) {
		String jpql="update Contacto c set c.email =?1 where c.idContacto=?2";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, idContacto);
		query.executeUpdate();
		
		
		/*Contacto c=eManager.find(Contacto.class, idContacto);
		if(c!=null) {
			c.setEmail(email);
			eManager.merge(c);
		}*/
	}

	
}
