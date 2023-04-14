package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//esto es un JavaBean 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagina {
	private String direccion;
	private String tematica;
	private String descripcion;
	
}
