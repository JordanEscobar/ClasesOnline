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

import com.clasesOnline.clasesOnline.Entity.Aula_virtual;
import com.clasesOnline.clasesOnline.Service.Aula_virtualServiceImpl;

@RestController
@RequestMapping("/api/aula")
public class Aula_virtualController {
	@Autowired
	private final Aula_virtualServiceImpl aula_virtualService;

	public Aula_virtualController(Aula_virtualServiceImpl aula_virtualService) {
		super();
		this.aula_virtualService = aula_virtualService;
	}

//Crear Aula_virtual
	@PostMapping
	public Aula_virtual crearAula_virtual(@RequestBody @Valid Aula_virtual aula_virtual) {
		return aula_virtualService.CrearAula_virtual(aula_virtual);
	}

	// Buscar Aula_virtual por ID
	@GetMapping("/{id}")
	public Aula_virtual getAula_virtualById(@PathVariable Integer id) {
		return aula_virtualService.getAula_virtualById(id);
	}

	// Mostrar Aula_virtual
	@GetMapping
	public List<Aula_virtual> findAll() {
		return aula_virtualService.findAll();
	}

	// Eliminar Aula_virtual
	@DeleteMapping("/eliminar/{id}")
	public void deleteAula_virtual(@PathVariable Integer id) {
		aula_virtualService.deleteAula_virtual(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar Aula_virtual
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody Aula_virtual aula_virtual, @PathVariable Integer id) {
		aula_virtualService.actualizarAula_virtual(aula_virtual, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
