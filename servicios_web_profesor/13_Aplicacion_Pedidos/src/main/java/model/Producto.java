package model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
	
	private int idPedido;
	@JsonAlias("producto")
	private String nombre;
	private int unidades;
	private Date fecha;
	private String tienda;

}
