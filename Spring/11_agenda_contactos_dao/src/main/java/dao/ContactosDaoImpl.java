package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Contacto;

@Repository
public class ContactosDaoImpl implements ContactosDao {
	@PersistenceContext
	EntityManager eManager;
	@Transactional
	@Override
	public void save(Contacto contacto) {
		eManager.persist(contacto);
	}

	@Override
	public Contacto findByIdContacto(int idContacto) {
		return eManager.find(Contacto.class, idContacto);
	}

	@Override
	public Contacto findByNombre(String nombre) {
		String jpql="select c from Contacto c where c.nombre = ?1";
		TypedQuery<Contacto> query=eManager.createQuery(jpql,Contacto.class);
		query.setParameter(1, nombre);
		List<Contacto> contactos= query.getResultList();
		return contactos.size()>0?contactos.get(0):null;
	}

	@Override
	public List<Contacto> findAll() {
		String jpql="select c from Contacto c";
		TypedQuery<Contacto> query=eManager.createQuery(jpql,Contacto.class);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void deleteByNombre(String nombre) {
		String jpql="delete from Contacto c where c.nombre=?1";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
	}
	@Transactional
	@Override
	public void deleteByIdContacto(int idContacto) {
		String jpql="delete from Contacto c where c.idContacto=?1";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, idContacto);
		query.executeUpdate();
	}
	
	

}
