package com.clasesOnline.clasesOnline.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clasesOnline.clasesOnline.Entity.Seguridad;
import com.clasesOnline.clasesOnline.Service.SeguridadServiceImpl;

@RestController
@RequestMapping("/api/seguridad")
public class SeguridadController {
	private final SeguridadServiceImpl seguridadService;

	public SeguridadController(SeguridadServiceImpl seguridadService) {
		super();
		this.seguridadService = seguridadService;
	}

	// Crear Seguridad
	@PostMapping
	public Seguridad crearSeguridad(@RequestBody @Valid Seguridad seguridad) {
		return seguridadService.CrearSeguridad(seguridad);
	}

	// Buscar Seguridad por ID
	@GetMapping("/{id}")
	public Seguridad getSeguridadById(@PathVariable Integer id) {
		return seguridadService.getSeguridadById(id);
	}

	// Mostrar Seguridad
	@GetMapping
	public List<Seguridad> findAll() {
		return seguridadService.findAll();
	}

	// Eliminar Seguridad
	@DeleteMapping("/eliminar/{id}")
	public void deleteSeguridad(@PathVariable Integer id) {
		seguridadService.deleteSeguridad(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar Seguridad
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody Seguridad seguridad, @PathVariable Integer id) {
		seguridadService.actualizarSeguridad(seguridad, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
