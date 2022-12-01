package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.Administrador;

public interface AdministradorService {
	public Administrador CrearAdministrador(Administrador administrador);

	public Administrador getAdministradorById(Integer id);

	public List<Administrador> findAll();

	public void deleteAdministrador(Integer id);

	public void actualizarAdministrador(Administrador administrador, Integer id);

}
