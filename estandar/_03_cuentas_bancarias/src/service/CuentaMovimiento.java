package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import model.Movimiento;

/*
 * 
 * Incluirá un método que devolverá la
 * LISTA de movimientos realizados por la cuenta
 * 
 * Cada movimiento tiene:
 * 
 * - Tipo (ingreso o extracción)
 * - Cantidad
 * 
 */

public class CuentaMovimiento extends CuentaLimitada {

	// seleccionamos el ResourceBundle
	Locale currentLocale = new Locale ("","");
	ResourceBundle messages = ResourceBundle.getBundle("res.ResourceBundle", currentLocale);

	// contenedor de MOVIMIENTOS
	List<Movimiento> movimientos = new ArrayList<>();
	
	public CuentaMovimiento(double saldo, double limite) {
		super(saldo, limite);
	}
	
	// método RECUPERARMOVIMIENTOS
	
	public List<Movimiento> recuperarMovimientos(){
		
		return movimientos;
		
	}
	
	@Override
	public void ingresar(double cantidad) {
		
		movimientos.add(new Movimiento("" + messages.getString("ingreso") + "", cantidad));
		super.ingresar(cantidad);

	}
	
	@Override
	public void extraer(double cantidad) {

		movimientos.add(new Movimiento("" + messages.getString("extraccion") + "", cantidad));
		super.extraer(cantidad);

	}
	
	
}
