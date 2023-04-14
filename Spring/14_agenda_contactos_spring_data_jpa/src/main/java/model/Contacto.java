package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contactos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContacto;
	@Column(name = "nombre")
	private String nombre;
	private String email;
	private int edad;
}
