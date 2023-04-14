package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cuentas")
public class Cuentas {
	
	private int numeroCuenta;
	private double saldo;
	private String tipocuenta;

}
