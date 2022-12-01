package com.clasesOnline.clasesOnline.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clasesOnline.clasesOnline.Entity.App_pago;
import com.clasesOnline.clasesOnline.Service.App_pagoServiceImpl;

@RestController
@RequestMapping("/api/pago")
public class App_pagoController {
	@Autowired
	private final App_pagoServiceImpl app_pagoService;

	public App_pagoController(App_pagoServiceImpl app_pagoService) {
		super();
		this.app_pagoService = app_pagoService;
	}

	// Crear App_pago
	@PostMapping
	public App_pago crearApp_pago(@RequestBody @Valid App_pago app_pago) {
		return app_pagoService.CrearApp_pago(app_pago);
	}

	// Buscar App_pago por ID
	@GetMapping("/{id}")
	public App_pago getApp_pagoById(@PathVariable Integer id) {
		return app_pagoService.getApp_pagoById(id);
	}

	// Mostrar App_pago
	@GetMapping
	public List<App_pago> findAll() {
		return app_pagoService.findAll();
	}

	// Eliminar App_pago
	@DeleteMapping("/eliminar/{id}")
	public void deleteApp_pago(@PathVariable Integer id) {
		app_pagoService.deleteApp_pago(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar App_pago
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody App_pago app_pago, @PathVariable Integer id) {
		app_pagoService.actualizarApp_pago(app_pago, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
