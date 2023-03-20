package org.luis.francisco.service;

import java.util.List;

import org.luis.francisco.entity.Vacante;

public interface IntVacantesService {
	public List<Vacante> obtenerVacantes();
	public void guardar(Vacante vacante);
	public Vacante buscarPorId(int idVacante);
	public void eliminar(int idVacante);
}
