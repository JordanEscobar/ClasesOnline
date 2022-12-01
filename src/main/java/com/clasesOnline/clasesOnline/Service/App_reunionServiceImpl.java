package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasesOnline.clasesOnline.Entity.App_reunion;
import com.clasesOnline.clasesOnline.Repository.App_reunionRepository;

@Service
public class App_reunionServiceImpl implements App_reunionService {
	@Autowired
	public final App_reunionRepository app_reunionRepository;

	public App_reunionServiceImpl(App_reunionRepository app_reunionRepository) {
		super();
		this.app_reunionRepository = app_reunionRepository;
	}

	@Override
	@Transactional
	public App_reunion CrearApp_reunion(App_reunion app_reunion) {
		return app_reunionRepository.save(app_reunion);
	}

	@Override
	@Transactional
	public App_reunion getApp_reunionById(Integer id) {
		return app_reunionRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<App_reunion> findAll() {
		return app_reunionRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteApp_reunion(Integer id) {
		app_reunionRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarApp_reunion(App_reunion app_reunion, Integer id) {
		Optional<App_reunion> app_reunionId = app_reunionRepository.findById(id);
		App_reunion app_reunionNuevo = app_reunionId.get();
		app_reunionNuevo.setDescripcion(app_reunion.getDescripcion());
		app_reunionNuevo.setFecha(app_reunion.getFecha());
		app_reunionRepository.save(app_reunionNuevo);
	}

}
