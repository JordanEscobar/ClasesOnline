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
import com.clasesOnline.clasesOnline.Entity.App_reunion;
import com.clasesOnline.clasesOnline.Service.App_reunionServiceImpl;

@RestController
@RequestMapping("/api/reunion")
public class App_reunionController {
	@Autowired
	private final App_reunionServiceImpl app_reunionService;

	public App_reunionController(App_reunionServiceImpl app_reunionService) {
		super();
		this.app_reunionService = app_reunionService;
	}

	// Crear App_reunion
	@PostMapping
	public App_reunion crearApp_reunion(@RequestBody @Valid App_reunion app_reunion) {
		return app_reunionService.CrearApp_reunion(app_reunion);
	}

	// Buscar App_reunion por ID
	@GetMapping("/{id}")
	public App_reunion getApp_reunionById(@PathVariable Integer id) {
		return app_reunionService.getApp_reunionById(id);
	}

	// Mostrar App_reunion
	@GetMapping
	public List<App_reunion> findAll() {
		return app_reunionService.findAll();
	}

	// Eliminar App_reunion
	@DeleteMapping("/eliminar/{id}")
	public void deleteApp_reunion(@PathVariable Integer id) {
		app_reunionService.deleteApp_reunion(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar App_reunion
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody App_reunion app_reunion, @PathVariable Integer id) {
		app_reunionService.actualizarApp_reunion(app_reunion, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
