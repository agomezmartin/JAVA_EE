package service;

import java.util.List;

import model.Movimiento;

public interface CajeroService {
	boolean comprobarCuenta(int numeroCuenta);
	void ingresar(int numeroCuenta, double importe);
	void extraer(int numeroCuenta, double importe);
	void transferir(int numeroCuentaOrigen, int numeroCuentaDestino, double importe);
	List<Movimiento> consultarMovimientos(int numeroCuenta);
	double consultarSaldo(int numeroCuenta);
}
