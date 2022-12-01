package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasesOnline.clasesOnline.Entity.App_pago;
import com.clasesOnline.clasesOnline.Repository.App_pagoRepository;

@Service
public class App_pagoServiceImpl implements App_pagoService {
	@Autowired
	private final App_pagoRepository app_pagoRepository;

	public App_pagoServiceImpl(App_pagoRepository app_pagoRepository) {
		super();
		this.app_pagoRepository = app_pagoRepository;
	}

	@Override
	@Transactional
	public App_pago CrearApp_pago(App_pago app_pago) {
		return app_pagoRepository.save(app_pago);
	}

	@Override
	@Transactional
	public App_pago getApp_pagoById(Integer id) {
		return app_pagoRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<App_pago> findAll() {
		return app_pagoRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteApp_pago(Integer id) {
		app_pagoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarApp_pago(App_pago app_pago, Integer id) {
		Optional<App_pago> app_pagoId = app_pagoRepository.findById(id);
		App_pago app_pagoNuevo = app_pagoId.get();
		app_pagoNuevo.setCantidad_a_pagar(app_pago.getCantidad_a_pagar());
		app_pagoNuevo.setDescuento(app_pago.getDescuento());
		app_pagoNuevo.setFormato_pago(app_pago.getFormato_pago());
		app_pagoNuevo.setId_alumno(app_pago.getId_alumno());
		app_pagoRepository.save(app_pagoNuevo);
	}

}
