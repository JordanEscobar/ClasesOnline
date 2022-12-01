package com.clasesOnline.clasesOnline.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "app_pago")
public class App_pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@NotEmpty
	@NotNull
	@Length(min = 1, max = 255)
	private String formato_pago;
	@NotNull
	@Min(value = 1)
	private int cantidad_a_pagar;
	@NotNull
	@Min(value = 0)
	private float descuento;
	@NotNull
	@Min(value = 1)
	private int id_alumno;

	public App_pago(Integer id, String formato_pago, int cantidad_a_pagar, float descuento, int id_alumno) {
		super();
		this.id = id;
		this.formato_pago = formato_pago;
		this.cantidad_a_pagar = cantidad_a_pagar;
		this.descuento = descuento;
		this.id_alumno = id_alumno;
	}

	public App_pago() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFormato_pago() {
		return formato_pago;
	}

	public void setFormato_pago(String formato_pago) {
		this.formato_pago = formato_pago;
	}

	public int getCantidad_a_pagar() {
		return cantidad_a_pagar;
	}

	public void setCantidad_a_pagar(int cantidad_a_pagar) {
		this.cantidad_a_pagar = cantidad_a_pagar;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

}
