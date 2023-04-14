package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Movimiento;
@Repository
public class MovimientosDaoImpl implements MovimientosDao {
	@PersistenceContext
	EntityManager eManager;
	@Override
	public List<Movimiento> findMovimientosCuenta(int numeroCuenta) {
		String jpql="select m from Movimiento m where m.idCuenta=?1";
		TypedQuery<Movimiento> query=eManager.createQuery(jpql,Movimiento.class);
		query.setParameter(1, numeroCuenta);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void save(Movimiento movimiento) {
		eManager.persist(movimiento);

	}

}
