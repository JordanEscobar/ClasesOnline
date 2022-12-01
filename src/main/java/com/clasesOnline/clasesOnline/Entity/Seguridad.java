package com.clasesOnline.clasesOnline.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "seguridad")
public class Seguridad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@NotEmpty
	@Future
	private Date fecha;
	@NotNull
	@NotEmpty
	@Min(value = 2)
	@Length(min = 2, max = 255)
	private String log;
	@NotNull
	@NotEmpty
	@Min(value = 1)
	private Integer id_login;

	public Seguridad(Integer id, Date fecha, String log, Integer id_login) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.log = log;
		this.id_login = id_login;
	}

	public Seguridad() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Integer getId_login() {
		return id_login;
	}

	public void setId_login(Integer id_login) {
		this.id_login = id_login;
	}

}
