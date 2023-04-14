package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Cuenta;
@Repository
public class CuentasDaoImpl implements CuentasDao {
	@PersistenceContext
	EntityManager eManager;
	@Transactional
	@Override
	public void update(Cuenta cuenta) {
		eManager.merge(cuenta);

	}
	@Transactional
	@Override
	public Cuenta findByNumeroCuenta(int numeroCuenta) {
		return eManager.find(Cuenta.class, numeroCuenta);
	}

}
