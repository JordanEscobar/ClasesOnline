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
@Table(name = "alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotEmpty
	@Length(min = 9, max = 11)
	@Pattern(regexp = "^[0-9]+-[0-9kK]{1}$",message = "Ingrese sin puntos y con guión")
	private String rut;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 2, max = 50)
	@Pattern(regexp = "[aA-zZ]*", message = "Ingrese solo letras ")
	private String nombre;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 2, max = 100)
	@Pattern(regexp = "[aA-zZ]*", message = "Ingrese solo letras ")
	private String apellido;
	@NotBlank
	@NotEmpty
	@NotNull
	@Email
	private String correo;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 2, max = 100)
	private String curso;
	@NotBlank
	@NotEmpty
	@NotNull
	@Min(value = 6)
	private String password;
	@NotNull
	@Min(value = 1)
	private int loginuser;

	public Alumno(int id, String rut, String nombre, String apellido, String correo, String password, String curso,
			int loginuser) {
		super();
		this.id = id;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.curso = curso;
		this.loginuser = loginuser;
	}

	public Alumno() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		if (rut != null) {
			this.rut = rut;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if (apellido != null) {
			this.apellido = apellido;
		}
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		if (correo != null) {
			this.correo = correo;
		}
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		if (curso != null) {
			this.curso = curso;
		}
	}

	public int getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(int loginuser) {
		if (loginuser != 0) {
			this.loginuser = loginuser;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", correo="
				+ correo + ", curso=" + curso + ", loginuser=" + loginuser + "]";
	}

}
