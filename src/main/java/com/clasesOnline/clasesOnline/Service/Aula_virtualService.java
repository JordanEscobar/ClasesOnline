package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.Aula_virtual;

public interface Aula_virtualService {
	public Aula_virtual CrearAula_virtual(Aula_virtual aula_virtual);

	public Aula_virtual getAula_virtualById(Integer id);

	public List<Aula_virtual> findAll();

	public void deleteAula_virtual(Integer id);

	public void actualizarAula_virtual(Aula_virtual aula_virtual, Integer id);
}
