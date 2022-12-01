package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.Alumno;

public interface AlumnoService {

	public Alumno CrearAlumno(Alumno alumno);

	public Alumno getAlumnoById(Integer id);

	public List<Alumno> findAll();

	public void deleteAlumno(Integer id);

	public void actualizarAlumno(Alumno alumno, Integer id);

}
