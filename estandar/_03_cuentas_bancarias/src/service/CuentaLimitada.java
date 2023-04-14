package service;

public class CuentaLimitada extends CuentaBanco {
	
	private double limite;
	
	public CuentaLimitada (double limite) {
		this.limite = limite;
	}
	
	public CuentaLimitada (double saldo, double limite) {
		super(saldo);
		this.limite = limite;
	}
	
	@Override
	public void extraer(double cantidad) {
		
		if(cantidad > limite) {
			super.extraer(limite);
		} else {
			super.extraer(cantidad);
		}
		
	}

}