package service;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CuentasDao;
import dao.MovimientosDao;
import model.Cuenta;
import model.Movimiento;

@Service
public class CajeroServiceImpl implements CajeroService {
	@Autowired
	CuentasDao cuentasDao;
	@Autowired
	MovimientosDao movimientosDao;

	@Override
	public boolean comprobarCuenta(int numeroCuenta) {
		return cuentasDao.findByNumeroCuenta(numeroCuenta)!=null;
	}
	@Transactional
	@Override
	public void ingresar(int numeroCuenta, double importe) {
		Cuenta cuenta=cuentasDao.findByNumeroCuenta(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+importe);
		cuentasDao.update(cuenta);
		Movimiento mov=new Movimiento(0, numeroCuenta, new Date(), importe, "ingreso");
		movimientosDao.save(mov);

	}
	@Transactional
	@Override
	public void extraer(int numeroCuenta, double importe) {
		Cuenta cuenta=cuentasDao.findByNumeroCuenta(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo()-importe);
		cuentasDao.update(cuenta);
		Movimiento mov=new Movimiento(0, numeroCuenta, new Date(), importe, "extracción");
		movimientosDao.save(mov);

	}
	@Transactional
	@Override
	public void transferir(int numeroCuentaOrigen, int numeroCuentaDestino, double importe) {
		extraer(numeroCuentaOrigen,importe);
		ingresar(numeroCuentaDestino,importe);

	}

	@Override
	public List<Movimiento> consultarMovimientos(int numeroCuenta) {
		return movimientosDao.findMovimientosCuenta(numeroCuenta);
	}

	@Override
	public double consultarSaldo(int numeroCuenta) {
		Cuenta cuenta=cuentasDao.findByNumeroCuenta(numeroCuenta);
		return cuenta.getSaldo();
	}

}
