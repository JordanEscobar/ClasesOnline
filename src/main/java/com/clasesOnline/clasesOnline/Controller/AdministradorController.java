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
import com.clasesOnline.clasesOnline.Entity.Administrador;
import com.clasesOnline.clasesOnline.Exception.RequestException;
import com.clasesOnline.clasesOnline.Service.AdministradorServiceImpl;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
	@Autowired
	private final AdministradorServiceImpl administradorService;

	public AdministradorController(AdministradorServiceImpl administradorService) {
		super();
		this.administradorService = administradorService;
	}

	// Crear Administrador
	@PostMapping
	public Administrador crearAdministrador(@RequestBody @Valid Administrador administrador) {
		Administrador adminNuevo = new Administrador();
		adminNuevo.setNombre(administrador.getNombre());
		adminNuevo.setApellido(administrador.getApellido());
		adminNuevo.setIdusuario(administrador.getIdusuario());
		adminNuevo.setPassword(administrador.getPassword());
		String rutExistente = "";

		for (int i = 0; i < administradorService.findAll().size(); i++) {
			if (administrador.getRut().equalsIgnoreCase(administradorService.findAll().get(i).getRut())) {
				rutExistente = administradorService.findAll().get(i).getRut();
			}
		}
		System.out.println("El rut es: " + rutExistente);
		if (administrador.getRut().equals(rutExistente)) {
			throw new RequestException("P-300", "El Rut es inválido");
		} else {
			adminNuevo.setRut(administrador.getRut());
		}
		String correoExistente = "";

		for (int i = 0; i < administradorService.findAll().size(); i++) {
			if (administrador.getCorreo().equalsIgnoreCase(administradorService.findAll().get(i).getCorreo())) {
				correoExistente = administradorService.findAll().get(i).getCorreo();
			}
		}
		System.out.println("El correo es: " + correoExistente);
		if (administrador.getCorreo().equals(correoExistente)) {
			throw new RequestException("P-300", "El correo es inválido");
		} else {
			adminNuevo.setCorreo(administrador.getCorreo());
		}

		return administradorService.CrearAdministrador(adminNuevo);
	}

	// Buscar Administrador por ID
	@GetMapping("/{id}")
	public Administrador getAdministradorById(@PathVariable Integer id) {
		return administradorService.getAdministradorById(id);
	}

	// Mostrar Administrador
	@GetMapping
	public List<Administrador> findAll() {
		return administradorService.findAll();
	}

	// Eliminar Administrador
	@DeleteMapping("/eliminar/{id}")
	public void deleteAdministrador(@PathVariable Integer id) {
		administradorService.deleteAdministrador(id);
	}

	// Editar Administrador
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody Administrador administrador, @PathVariable Integer id) {
		administradorService.actualizarAdministrador(administrador, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
