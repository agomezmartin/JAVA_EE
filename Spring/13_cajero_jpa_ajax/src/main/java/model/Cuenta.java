package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {
	@Id
	private int numeroCuenta;
	private double saldo;
	private String tipocuenta;
	public Cuenta(int numeroCuenta, double saldo, String tipocuenta) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipocuenta = tipocuenta;
	}
	public Cuenta() {
		
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipocuenta() {
		return tipocuenta;
	}
	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	
}
