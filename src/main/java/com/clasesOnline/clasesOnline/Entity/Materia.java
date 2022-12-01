package com.clasesOnline.clasesOnline.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_materia;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 1, max = 100)
	private String nombre;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 3, max = 255)
	private String categoria;
	@NotNull
	private Integer id_profesor;

	public Materia(Integer id_materia, String nombre, String categoria, Integer id_profesor) {
		super();
		this.id_materia = id_materia;
		this.nombre = nombre;
		this.categoria = categoria;
		this.id_profesor = id_profesor;
	}

	public Materia() {
		super();
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(Integer id_profesor) {
		this.id_profesor = id_profesor;
	}

	@Override
	public String toString() {
		return "Materia [id_materia=" + id_materia + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", id_profesor=" + id_profesor + "]";
	}

}
