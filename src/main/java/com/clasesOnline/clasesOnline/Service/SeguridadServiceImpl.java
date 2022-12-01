package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasesOnline.clasesOnline.Entity.Seguridad;
import com.clasesOnline.clasesOnline.Repository.SeguridadRepository;

@Service
public class SeguridadServiceImpl implements SeguridadService {
	@Autowired
	private final SeguridadRepository seguridadRepository;

	public SeguridadServiceImpl(SeguridadRepository seguridadRepository) {
		super();
		this.seguridadRepository = seguridadRepository;
	}

	@Override
	@Transactional
	public Seguridad CrearSeguridad(Seguridad seguridad) {
		return seguridadRepository.save(seguridad);
	}

	@Override
	@Transactional
	public Seguridad getSeguridadById(Integer id) {
		return seguridadRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Seguridad> findAll() {
		return seguridadRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteSeguridad(Integer id) {
		seguridadRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarSeguridad(Seguridad seguridad, Integer id) {
		Optional<Seguridad> seguridadId = seguridadRepository.findById(id);
		Seguridad seguridadNuevo = seguridadId.get();
		seguridadNuevo.setFecha(seguridad.getFecha());
		seguridadNuevo.setLog(seguridad.getLog());
		seguridadNuevo.setId_login(seguridad.getId());
		seguridadRepository.save(seguridadNuevo);
	}

}
