package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pais {
	
	private String name;
	private String capital;
	private String continent;
	private String population;
	private String flag;

}