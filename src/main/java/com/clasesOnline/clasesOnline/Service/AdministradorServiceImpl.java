package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasesOnline.clasesOnline.Entity.Administrador;
import com.clasesOnline.clasesOnline.Repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService {
	@Autowired
	private final AdministradorRepository administradorRepository;

	public AdministradorServiceImpl(AdministradorRepository administradorRepository) {
		super();
		this.administradorRepository = administradorRepository;
	}

	@Override
	@Transactional
	public Administrador CrearAdministrador(Administrador administrador) {
		return administradorRepository.save(administrador);
	}

	@Override
	@Transactional
	public Administrador getAdministradorById(Integer id) {
		return administradorRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Administrador> findAll() {
		return administradorRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteAdministrador(Integer id) {
		administradorRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarAdministrador(Administrador administrador, Integer id) {
		Optional<Administrador> administradorId = administradorRepository.findById(id);

		Administrador administradorNuevo = administradorId.get();
		administradorNuevo.setNombre(administrador.getNombre());
		administradorNuevo.setApellido(administrador.getApellido());
		administradorNuevo.setCorreo(administrador.getCorreo());
		administradorNuevo.setPassword(administrador.getPassword());
		administradorNuevo.setRut(administrador.getRut());
		administradorNuevo.setIdusuario(administrador.getIdusuario());
		this.administradorRepository.save(administradorNuevo);

	}

}
