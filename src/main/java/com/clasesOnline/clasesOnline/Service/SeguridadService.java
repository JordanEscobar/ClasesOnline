package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.Seguridad;

public interface SeguridadService {
	public Seguridad CrearSeguridad(Seguridad seguridad);

	public Seguridad getSeguridadById(Integer id);

	public List<Seguridad> findAll();

	public void deleteSeguridad(Integer id);

	public void actualizarSeguridad(Seguridad seguridad, Integer id);
}
