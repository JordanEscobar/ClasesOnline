package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.Profesor;

public interface ProfesorService {
	public Profesor CrearProfesor(Profesor profesor);

	public Profesor getProfesorById(Integer id);

	public List<Profesor> findAll();

	public void deleteProfesor(Integer id);

	public void actualizarProfesor(Profesor profesor, Integer id);
}
