package com.clasesOnline.clasesOnline.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "profesor")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 6, max = 11)
	@Pattern(regexp = "^[0-9]+-[0-9kK]{1}$",message = "Ingrese sin puntos y con guión")
	private String rut;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 25)
	@Pattern(regexp = "[aA-zZ]*", message = "Ingrese solo letras ")
	private String nombre;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 25)
	@Pattern(regexp = "[aA-zZ]*", message = "Ingrese solo letras ")
	private String apellido;
	@NotBlank
	@NotEmpty
	@NotNull
	@Email
	@Length(min = 5, max = 50)
	private String correo;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 1, max = 100)
	private String password;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 1, max = 255)
	private String especializacion;
	@NotNull
	@Min(value = 1)
	private Integer idlogpro;

	public Profesor(Integer id, String rut, String nombre, String apellido, String correo, String password,
			String especializacion, Integer idlogpro) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.especializacion = especializacion;
		this.idlogpro = idlogpro;
	}

	public Profesor() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}

	public Integer getIdlogpro() {
		return idlogpro;
	}

	public void setIdlogpro(Integer idlogpro) {
		this.idlogpro = idlogpro;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", correo="
				+ correo + ", password=" + password + ", especializacion=" + especializacion + ", idlogpro=" + idlogpro
				+ "]";
	}

}
