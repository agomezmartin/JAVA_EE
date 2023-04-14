package model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movimientos {
	
	private int idMovimiento;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuenta;
	private Date fecha;
	private int cantidad;
	private String operacon;

}
