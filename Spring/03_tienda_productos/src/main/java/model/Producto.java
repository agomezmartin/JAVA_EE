package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	private String nombre;
	private String seccion;
	private double precio;
	private int stock;
	
	
}
