package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.Materia;

public interface MateriaService {
	public Materia CrearMateria(Materia materia);

	public Materia getMateriaById(Integer id);

	public String getMateriaByProfesorId(Integer id_profesor);

	public List<Materia> findAll();

	public void deleteMateria(Integer id);

	public void actualizarMateria(Materia materia, Integer id);
}
