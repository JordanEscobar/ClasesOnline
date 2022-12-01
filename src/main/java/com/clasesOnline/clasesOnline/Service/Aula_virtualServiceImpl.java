package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasesOnline.clasesOnline.Entity.Aula_virtual;
import com.clasesOnline.clasesOnline.Repository.Aula_virtualRepository;

@Service
public class Aula_virtualServiceImpl implements Aula_virtualService {
	@Autowired
	private final Aula_virtualRepository aula_virtualRepository;

	public Aula_virtualServiceImpl(Aula_virtualRepository aula_virtualRepository) {
		super();
		this.aula_virtualRepository = aula_virtualRepository;
	}

	@Override
	@Transactional
	public Aula_virtual CrearAula_virtual(Aula_virtual aula_virtual) {
		return aula_virtualRepository.save(aula_virtual);
	}

	@Override
	@Transactional
	public Aula_virtual getAula_virtualById(Integer id) {
		return aula_virtualRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Aula_virtual> findAll() {
		return aula_virtualRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteAula_virtual(Integer id) {
		aula_virtualRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarAula_virtual(Aula_virtual aula_virtual, Integer id) {
		Optional<Aula_virtual> aula_virtualId = aula_virtualRepository.findById(id);
		Aula_virtual aula_virtualNuevo = aula_virtualId.get();
		aula_virtualNuevo.setId_agenda(aula_virtual.getId_agenda());
		aula_virtualNuevo.setId_alumno(aula_virtual.getId_alumno());
		aula_virtualNuevo.setId_materia(aula_virtual.getId_materia());
		aula_virtualNuevo.setId_profesor(aula_virtual.getId_profesor());
		aula_virtualNuevo.setId_reunion(aula_virtual.getId_reunion());
		aula_virtualRepository.save(aula_virtualNuevo);

	}

}
