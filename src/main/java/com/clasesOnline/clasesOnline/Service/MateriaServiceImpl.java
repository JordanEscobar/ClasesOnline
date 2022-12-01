package com.clasesOnline.clasesOnline.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clasesOnline.clasesOnline.Entity.Materia;
import com.clasesOnline.clasesOnline.Entity.Profesor;
import com.clasesOnline.clasesOnline.Repository.MateriaRepository;
import com.clasesOnline.clasesOnline.Repository.ProfesorRepository;

@Service
public class MateriaServiceImpl implements MateriaService {
	@Autowired
	private final MateriaRepository materiaRepository;
	@Autowired
	private final ProfesorRepository profesorRepository;

	public MateriaServiceImpl(MateriaRepository materiaRepository, ProfesorRepository profesorRepository) {
		super();
		this.materiaRepository = materiaRepository;
		this.profesorRepository = profesorRepository;
	}

	@Override
	@Transactional
	public Materia CrearMateria(Materia materia) {
		return materiaRepository.save(materia);
	}

	@Override
	@Transactional
	public Materia getMateriaById(Integer id) {
		return materiaRepository.findById(id).get();
	}

	@Override
	@Transactional
	public String getMateriaByProfesorId(Integer id_profesor) {
		List<Materia> materiaList = materiaRepository.findAll();
		materiaList = materiaList.stream().filter(p -> p.getId_profesor() == id_profesor).collect(Collectors.toList());

		Optional<Profesor> profesor = profesorRepository.findById(id_profesor);
		String profesorSeleccionado = profesor.get().getNombre().toString() + " "
				+ profesor.get().getApellido().toString();
		String materias = "";
		for (int i = 0; i < materiaList.size(); i++) {
			materias = materias + " Nombre: " + materiaList.get(i).getNombre().toString() + ". Categoria: "
					+ materiaList.get(i).getCategoria().toString() + " \n";
		}
		return "Profesor: " + profesorSeleccionado + " \n" + " Materias: " + " \n" + materias;
	}

	@Override
	@Transactional
	public List<Materia> findAll() {
		return materiaRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteMateria(Integer id) {
		materiaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void actualizarMateria(Materia materia, Integer id) {
		Optional<Materia> materiaId = materiaRepository.findById(id);
		Materia materiaNueva = materiaId.get();
		materiaNueva.setCategoria(materia.getCategoria());
		materiaNueva.setNombre(materia.getNombre());
		materiaNueva.setId_profesor(materia.getId_profesor());
		this.materiaRepository.save(materiaNueva);

	}

}
