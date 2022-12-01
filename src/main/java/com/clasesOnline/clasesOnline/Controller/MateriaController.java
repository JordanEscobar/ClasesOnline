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
import com.clasesOnline.clasesOnline.Entity.Materia;
import com.clasesOnline.clasesOnline.Service.MateriaServiceImpl;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {
	@Autowired
	private final MateriaServiceImpl materiaService;

	public MateriaController(MateriaServiceImpl materiaService) {
		super();
		this.materiaService = materiaService;
	}

	// Crear Materia
	@PostMapping
	public Materia crearMateria(@RequestBody @Valid Materia materia) {
		return materiaService.CrearMateria(materia);
	}

	// Buscar Materia por ID
	@GetMapping("/{id}")
	public Materia getMateriaById(@PathVariable Integer id) {
		return materiaService.getMateriaById(id);
	}

	// Mostrar materias por profesor
	@GetMapping("/porprofesor/{id}")
	public String findProfesorByid(@PathVariable Integer id) {
		return materiaService.getMateriaByProfesorId(id);
	}

	// Mostrar Materia
	@GetMapping
	public List<Materia> findAll() {
		return materiaService.findAll();
	}

	// Eliminar Materia
	@DeleteMapping("/eliminar/{id}")
	public void deleteMateria(@PathVariable Integer id) {
		materiaService.deleteMateria(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar Materia
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody Materia materia, @PathVariable Integer id) {
		materiaService.actualizarMateria(materia, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
