package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clasesOnline.clasesOnline.Entity.Alumno;
import com.clasesOnline.clasesOnline.Repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	@Autowired
	private final AlumnoRepository alumnoRepository;

	public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	@Override
	@Transactional
	public Alumno CrearAlumno(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public Alumno getAlumnoById(Integer id) {
		return alumnoRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteAlumno(Integer id) {
		alumnoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarAlumno(Alumno alumno, Integer id) {
		Optional<Alumno> alumnoId = alumnoRepository.findById(id);

		Alumno alumnoNuevo = alumnoId.get();
		alumnoNuevo.setRut(alumno.getRut());
		alumnoNuevo.setNombre(alumno.getNombre());
		alumnoNuevo.setApellido(alumno.getApellido());
		alumnoNuevo.setCorreo(alumno.getCorreo());
		alumnoNuevo.setPassword(alumno.getPassword());
		alumnoNuevo.setCurso(alumno.getCurso());
		alumnoNuevo.setLoginuser(alumno.getLoginuser());
		this.alumnoRepository.save(alumnoNuevo);
	}

}
