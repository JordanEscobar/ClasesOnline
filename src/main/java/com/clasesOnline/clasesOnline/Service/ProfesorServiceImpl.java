package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasesOnline.clasesOnline.Entity.Profesor;
import com.clasesOnline.clasesOnline.Repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	@Autowired
	public final ProfesorRepository profesorRepository;

	public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
		super();
		this.profesorRepository = profesorRepository;
	}

	@Override
	@Transactional
	public Profesor CrearProfesor(Profesor profesor) {
		return profesorRepository.save(profesor);
	}

	@Override
	@Transactional
	public Profesor getProfesorById(Integer id) {
		return profesorRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Profesor> findAll() {
		return profesorRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteProfesor(Integer id) {
		profesorRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarProfesor(Profesor profesor, Integer id) {
		Optional<Profesor> profesorId = profesorRepository.findById(id);

		Profesor profesorNuevo = profesorId.get();
		profesorNuevo.setApellido(profesor.getApellido());
		profesorNuevo.setCorreo(profesor.getCorreo());
		profesorNuevo.setPassword(profesor.getPassword());
		profesorNuevo.setEspecializacion(profesor.getEspecializacion());
		profesorNuevo.setIdlogpro(profesor.getIdlogpro());
		profesorNuevo.setNombre(profesor.getNombre());
		profesorNuevo.setRut(profesor.getRut());
		this.profesorRepository.save(profesorNuevo);
	}

}
