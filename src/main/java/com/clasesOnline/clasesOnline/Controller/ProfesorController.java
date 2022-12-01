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
import com.clasesOnline.clasesOnline.Entity.Profesor;
import com.clasesOnline.clasesOnline.Exception.RequestException;
import com.clasesOnline.clasesOnline.Service.ProfesorServiceImpl;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {
	@Autowired
	private final ProfesorServiceImpl profesorService;

	public ProfesorController(ProfesorServiceImpl profesorService) {
		super();
		this.profesorService = profesorService;
	}

	// Crear Profesor
	@PostMapping
	public Profesor crearProfesor(@RequestBody @Valid Profesor profesor) {
		Profesor profeNuevo = new Profesor();
		profeNuevo.setApellido(profesor.getApellido());
		profeNuevo.setEspecializacion(profesor.getEspecializacion());
		profeNuevo.setNombre(profesor.getNombre());
		profeNuevo.setPassword(profesor.getPassword());
		profeNuevo.setIdlogpro(profesor.getIdlogpro());
		String rutExistente = "";
		for (int i = 0; i < profesorService.findAll().size(); i++) {
			if (profesor.getRut().equalsIgnoreCase(profesorService.findAll().get(i).getRut())) {
				rutExistente = profesorService.findAll().get(i).getRut();
			}
		}
		System.out.println("El rut es: " + rutExistente);
		if (profesor.getRut().equals(rutExistente)) {
			throw new RequestException("P-300", "El Rut es inválido");
		} else {
			profeNuevo.setRut(profesor.getRut());
		}
		String correoExistente = "";

		for (int i = 0; i < profesorService.findAll().size(); i++) {
			if (profesor.getCorreo().equals(profesorService.findAll().get(i).getCorreo())) {
				correoExistente = profesorService.findAll().get(i).getCorreo();
			}
		}
		System.out.println("El correo es: " + correoExistente);
		if (profesor.getCorreo().equals(correoExistente)) {
			throw new RequestException("P-300", "El correo es inválido");
		} else {
			profeNuevo.setCorreo(profesor.getCorreo());
		}

		return profesorService.CrearProfesor(profeNuevo);
	}

	// Buscar Profesor por ID
	@GetMapping("/{id}")
	public Profesor getProfesorById(@PathVariable Integer id) {
		return profesorService.getProfesorById(id);
	}

	// Mostrar Profesor
	@GetMapping
	public List<Profesor> findAll() {
		return profesorService.findAll();
	}

	// Eliminar Profesor
	@DeleteMapping("/eliminar/{id}")
	public void deleteProfesor(@PathVariable Integer id) {
		profesorService.deleteProfesor(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar Alumno
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesorService.actualizarProfesor(profesor, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
