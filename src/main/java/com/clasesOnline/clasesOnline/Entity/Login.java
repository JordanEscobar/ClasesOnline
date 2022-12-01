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
@Table(name = "login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idus;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 1, max = 255)
	private String usuario;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 1, max = 255)
	private char nivel;

	public Login(Integer idus, String usuario, char nivel) {
		super();
		this.idus = idus;
		this.usuario = usuario;
		this.nivel = nivel;
	}

	public Login() {
		super();
	}

	public Integer getIdus() {
		return idus;
	}

	public void setIdus(Integer idus) {
		this.idus = idus;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public char getNivel() {
		return nivel;
	}

	public void setNivel(char nivel) {
		this.nivel = nivel;
	}

}
