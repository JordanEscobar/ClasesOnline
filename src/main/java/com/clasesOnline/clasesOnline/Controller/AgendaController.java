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

import com.clasesOnline.clasesOnline.Entity.Agenda;
import com.clasesOnline.clasesOnline.Service.AgendaServiceImpl;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
	@Autowired
	private final AgendaServiceImpl agendaService;

	public AgendaController(AgendaServiceImpl agendaService) {
		super();
		this.agendaService = agendaService;
	}

	// Crear Agenda
	@PostMapping
	public Agenda crearAgenda(@RequestBody @Valid Agenda agenda) {
		// Timestamp horaActual = new Timestamp(agenda.getHora().getTime());
		Agenda agendaNueva = new Agenda();
		agendaNueva.setFecha(agenda.getFecha());
		agendaNueva.setHora(agenda.getHora());
		agendaNueva.setId_profesor(agenda.getId_profesor());
		return agendaService.CrearAgenda(agendaNueva);
	}

	// Buscar Agenda por ID
	@GetMapping("/{id}")
	public Agenda getAgendaById(@PathVariable Integer id) {
		return agendaService.getAgendaById(id);
	}
	
	//Buscar Agendas por ID Profesor
	@GetMapping("/porprofesor/{id}")
	public String getAgendaPorProfesor(@PathVariable Integer id)
	{
		return agendaService.getAgendasPorProfesor(id);
	}

	// Mostrar Agenda
	@GetMapping
	public List<Agenda> findAll() {
		return agendaService.findAll();
	}

	// Eliminar Agenda
	@DeleteMapping("/eliminar/{id}")
	public void deleteAgenda(@PathVariable Integer id) {
		agendaService.deleteAgenda(id);
		ResponseEntity.ok(Boolean.TRUE);
	}

	// Editar Agenda
	@PutMapping("/editar/{id}")
	public void editar(@RequestBody Agenda agenda, @PathVariable Integer id) {
		agendaService.actualizarAgenda(agenda, id);
		ResponseEntity.ok(Boolean.TRUE);
	}

}
