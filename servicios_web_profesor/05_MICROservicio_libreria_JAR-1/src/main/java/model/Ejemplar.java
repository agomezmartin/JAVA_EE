package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ejemplar {
	
	private int isbn;
	private String titutlo;
	private double precio;

}