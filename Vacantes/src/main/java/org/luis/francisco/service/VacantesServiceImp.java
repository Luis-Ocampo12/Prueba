package org.luis.francisco.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.luis.francisco.entity.Vacante;

@Service
public class VacantesServiceImp implements IntVacantesService {
	
	private List<Vacante> vacantes;
	
	public VacantesServiceImp() {
		vacantes = new LinkedList<Vacante>();
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		try {
		Vacante v1 = new Vacante();
		v1.setId(1);
		v1.setNombre("Programador");
		v1.setDescripcion("Programación de aplicaciones moviles");
		v1.setFecha(LocalDate.parse("15-12-2022", formato));
		v1.setSalario(250.0);
		v1.setEstatus("Creada");
		v1.setDestacado(1);
		v1.setDetalles("<h2><strong>Requisitos</strong></h2>");
		v1.setImagen("logo11.png");
		
		Vacante v2 = new Vacante();
		v2.setId(2);
		v2.setNombre("Contador Público");
		v2.setDescripcion("Finanzas y Auditoría");
		v2.setFecha(LocalDate.parse("15-01-2023",formato));
		v2.setSalario(200.0);
		v2.setEstatus("Aprobada");
		v2.setDestacado(0);
		v2.setDetalles("<h2><strong>Requisitos</strong></h2>");
		v2.setImagen("logo12.png");
		
		vacantes.add(v1);
		vacantes.add(v2);
		
		}catch(DateTimeParseException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public List<Vacante> obtenerVacantes() {
		// TODO Auto-generated method stub
		return vacantes;
	}

	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		vacantes.add(vacante);
	}

	@Override
	public Vacante buscarPorId(int idVacante) {
		Vacante vacante = null;
		for(Vacante v : vacantes) {
			if(v.getId() == idVacante) {
				vacante = v;
			}
		}
		return vacante;
	}

	@Override
	public void eliminar(int idVacante) {
		// TODO Auto-generated method stub
		vacantes.remove(buscarPorId(idVacante));
	}

}