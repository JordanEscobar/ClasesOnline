package com.clasesOnline.clasesOnline.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aula_virtual")
public class Aula_virtual {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Min(value = 1)
	private Integer id_materia;
	@NotNull
	@Min(value = 1)
	private Integer id_profesor;
	@NotNull
	@Min(value = 1)
	private Integer id_alumno;
	@NotNull
	@Min(value = 1)
	private Integer id_agenda;
	@NotNull
	@Min(value = 1)
	private Integer id_reunion;

	public Aula_virtual(Integer id, Integer id_materia, Integer id_profesor, Integer id_alumno, Integer id_agenda,
			Integer id_reunion) {
		super();
		this.id = id;
		this.id_materia = id_materia;
		this.id_profesor = id_profesor;
		this.id_alumno = id_alumno;
		this.id_agenda = id_agenda;
		this.id_reunion = id_reunion;
	}

	public Aula_virtual() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public Integer getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(Integer id_profesor) {
		this.id_profesor = id_profesor;
	}

	public Integer getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
	}

	public Integer getId_agenda() {
		return id_agenda;
	}

	public void setId_agenda(Integer id_agenda) {
		this.id_agenda = id_agenda;
	}

	public Integer getId_reunion() {
		return id_reunion;
	}

	public void setId_reunion(Integer id_reunion) {
		this.id_reunion = id_reunion;
	}

}
