package dao;

import java.util.List;

import model.Movimientos;

public interface MovimientosDao {

	public boolean findTransfer(int idCuenta, int cantidad);
	public List<Movimientos> findTransactions(int idCuenta);
	

}
