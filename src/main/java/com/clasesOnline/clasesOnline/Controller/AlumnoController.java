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

import com.clasesOnline.clasesOnline.Entity.Alumno;
import com.clasesOnline.clasesOnline.Exception.RequestException;
import com.clasesOnline.clasesOnline.Service.AlumnoServiceImpl;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
	@Autowired
	private final AlumnoServiceImpl alumnoService;

	public AlumnoController(AlumnoServiceImpl alumnoService) {
		this.alumnoService = alumnoService;
	}

	// Crear Alumnos
	@PostMapping
	public Alumno crearAlumno(@Valid @RequestBody Alumno alumno) throws Exception {
		Alumno alumnoNuevo = new Alumno();
		alumnoNuevo.setApellido(alumno.getApellido());

		String correoExistente = "";

		for (int i = 0; i < alumnoService.findAll().size(); i++) {
			if (alumno.getCorreo().equalsIgnoreCase(alumnoService.findAll().get(i).getCorreo())) {
				correoExistente = alumnoService.findAll().get(i).getCorreo();
			}
		}
		System.out.println("El correo es: " + correoExistente);
		if (alumno.getCorreo().equals(correoExistente)) {
			throw new RequestException("P-300", "El correo es inválido");
		} else {
			alumnoNuevo.setCorreo(alumno.getCorreo());
		}
		alumnoNuevo.setPassword(alumno.getPassword());
		alumnoNuevo.setCurso(alumno.getCurso());
		alumnoNuevo.setLoginuser(alumno.getLoginuser());
		alumnoNuevo.setNombre(alumno.getNombre());

		String rutExistente = "";

		for (int i = 0; i < alumnoService.findAll().size(); i++) {
			if (alumno.getRut().equalsIgnoreCase(alumnoService.findAll().get(i).getRut())) {
				rutExistente = alumnoService.findAll().get(i).getRut();
			}
		}
		System.out.println("El rut es: " + rutExistente);
		if (alumno.getRut().equals(rutExistente)) {
			throw new RequestException("P-300", "El Rut es inválido");
		} else {
			alumnoNuevo.setRut(alumno.getRut());
		}
		return alumnoService.CrearAlumno(alumnoNuevo);
	}

	// Buscar Alumno por ID
	@GetMapping("/{id}")
	public Alumno getAlumnoById(@PathVariable Integer id) {
		return alumnoService.getAlumnoById(id);
	}

	// Mostrar Alumnos
	@GetMapping
	public List<Alumno> findAll() {
		return alumnoService.findAll();
	}

	// Eliminar Alumno
	@DeleteMapping("/eliminar/{id}")
	public void deleteAlumno(@PathVariable Integer id) {
		alumnoService.deleteAlumno(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar Alumno
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody Alumno alumno, @PathVariable Integer id) {
		alumnoService.actualizarAlumno(alumno, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
