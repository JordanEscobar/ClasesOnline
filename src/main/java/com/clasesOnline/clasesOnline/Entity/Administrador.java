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
@Table(name = "administrador")
public class Administrador {

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
	@Length(min = 2, max = 50)
	@Pattern(regexp = "[aA-zZ]*", message = "Ingrese solo letras ")
	private String nombre;
	@NotBlank
	@NotNull
	@NotEmpty
	@Length(min = 2, max = 100)
	@Pattern(regexp = "[aA-zZ]*", message = "Ingrese solo letras ")
	private String apellido;
	@NotBlank
	@NotNull
	@NotEmpty
	@Email
	private String correo;
	@NotBlank
	@NotNull
	@NotEmpty
	@Min(value = 6)
	private String password;
	@NotNull
	private int idusuario;

	public Administrador(Integer id, String rut, String nombre, String apellido, String correo, String password,
			int idusuario) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.idusuario = idusuario;
	}

	public Administrador() {
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

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", password=" + password + ", idusuario=" + idusuario + "]";
	}
	
	

}
