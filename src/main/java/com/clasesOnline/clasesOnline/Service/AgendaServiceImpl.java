package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasesOnline.clasesOnline.Entity.Agenda;
import com.clasesOnline.clasesOnline.Entity.Profesor;
import com.clasesOnline.clasesOnline.Repository.AgendaRepository;
import com.clasesOnline.clasesOnline.Repository.ProfesorRepository;

@Service
public class AgendaServiceImpl implements AgendaService {
	@Autowired
	private final AgendaRepository agendaRepository;
	@Autowired
	private final ProfesorRepository profesorRepository;

	public AgendaServiceImpl(AgendaRepository agendaRepository, ProfesorRepository profesorRepository) {
		super();
		this.agendaRepository = agendaRepository;
		this.profesorRepository = profesorRepository;
	}

	@Override
	@Transactional
	public Agenda CrearAgenda(Agenda agenda) {
		return agendaRepository.save(agenda);
	}

	@Override
	@Transactional
	public Agenda getAgendaById(Integer id) {
		return agendaRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Agenda> findAll() {
		return agendaRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteAgenda(Integer id) {
		agendaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarAgenda(Agenda agenda, Integer id) {
		Optional<Agenda> agendaId = agendaRepository.findById(id);
		Agenda agendaNuevo = agendaId.get();
		agendaNuevo.setFecha(agenda.getFecha());
		agendaNuevo.setHora(agenda.getHora());
		agendaNuevo.setId_profesor(agenda.getId_profesor());
		agendaRepository.save(agendaNuevo);
	}

	@Override
	@Transactional
	public String getAgendasPorProfesor(Integer id) {

		List<Agenda> agendaList = agendaRepository.findAll();
		agendaList = agendaList.stream().filter(p -> p.getId_profesor() == id).collect(Collectors.toList());

		Optional<Profesor> profesor = profesorRepository.findById(id);
		String profesorSeleccionado = profesor.get().getNombre().toString() + " "
				+ profesor.get().getApellido().toString();
		String materias = "";
		for (int i = 0; i < agendaList.size(); i++) {
			materias = materias + " Agenda: " + agendaList.get(i).getId().toString() + ". Fecha: "
					+ agendaList.get(i).getFecha().toString() + " \n";
		}
		return "Profesor: " + profesorSeleccionado.toString() + " \n" + " Agendas: " + " \n" + materias.toString();
	}

}
