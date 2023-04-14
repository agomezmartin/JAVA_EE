package dao;

import model.Cuenta;

public interface CuentasDao {
	void update(Cuenta cuenta);
	Cuenta findByNumeroCuenta(int numeroCuenta);
}
