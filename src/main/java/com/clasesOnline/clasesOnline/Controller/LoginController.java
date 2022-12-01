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
import com.clasesOnline.clasesOnline.Entity.Login;
import com.clasesOnline.clasesOnline.Service.LoginServiceImpl;

@RestController
@RequestMapping("/api/Login")
public class LoginController {
	@Autowired
	private final LoginServiceImpl loginService;

	public LoginController(LoginServiceImpl loginService) {
		super();
		this.loginService = loginService;
	}

	// Crear Login
	@PostMapping
	public Login crearLogin(@RequestBody @Valid Login login) {
		return loginService.CrearLogin(login);
	}

	// Buscar Login por ID
	@GetMapping("/{id}")
	public Login getLoginById(@PathVariable Integer id) {
		return loginService.getLoginById(id);
	}

	// Mostrar Login
	@GetMapping
	public List<Login> findAll() {
		return loginService.findAll();
	}

	// Eliminar Login
	@DeleteMapping("/eliminar/{id}")
	public void deleteLogin(@PathVariable Integer id) {
		loginService.deleteLogin(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar Login
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody Login login, @PathVariable Integer id) {
		loginService.actualizarLogin(login, id);
		ResponseEntity.ok(Boolean.TRUE);
	}
}
