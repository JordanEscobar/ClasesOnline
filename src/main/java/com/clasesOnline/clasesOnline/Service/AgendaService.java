package com.clasesOnline.clasesOnline.Service;

import java.util.List;

import com.clasesOnline.clasesOnline.Entity.Agenda;

public interface AgendaService {
	public Agenda CrearAgenda(Agenda agenda);

	public Agenda getAgendaById(Integer id);

	public List<Agenda> findAll();

	public void deleteAgenda(Integer id);

	public void actualizarAgenda(Agenda agenda, Integer id);
	
	public String getAgendasPorProfesor(Integer id);
}
