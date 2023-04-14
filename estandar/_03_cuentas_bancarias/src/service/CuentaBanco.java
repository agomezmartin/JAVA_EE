package service;

public class CuentaBanco {
	
	private double saldo;

	public CuentaBanco(double saldo) {
		super();
		this.saldo = saldo;
	}

	public CuentaBanco() {
		super();
	}

	//////////////////
	/*
	 * Métodos
	 * 
	 *///////////////
	public double consultarSaldo() {
		return saldo;
	}
	
	public void ingresar(double cantidad) {
		saldo += cantidad;
	}
	
	public void extraer(double cantidad) {
		saldo-=cantidad;
	}




}