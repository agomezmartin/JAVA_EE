package dao;

import java.util.List;

import model.Movimiento;

public interface MovimientosDao {
	List<Movimiento> findMovimientosCuenta(int numeroCuenta);
	void save(Movimiento movimiento);
}
