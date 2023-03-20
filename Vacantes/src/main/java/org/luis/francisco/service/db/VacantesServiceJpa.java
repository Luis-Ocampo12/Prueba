package org.luis.francisco.service.db;

import java.util.List;
import java.util.Optional;

import org.luis.francisco.entity.Vacante;
import org.luis.francisco.repository.VacantesRepository;
import org.luis.francisco.service.IntVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class VacantesServiceJpa implements IntVacantesService {
	
	@Autowired
	private VacantesRepository repoVacantes;

	@Override
	public List<Vacante> obtenerVacantes() {
		// TODO Auto-generated method stub
		return repoVacantes.findAll();
	}

	@Override
	public void guardar(Vacante vacante) {
		repoVacantes.save(vacante);
	}

	@Override
	public Vacante buscarPorId(int idVacante) {
		// TODO Auto-generated method stub
		Optional<Vacante> optional = repoVacantes.findById(idVacante);
		if ( optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idVacante) {
		// TODO Auto-generated method stub

	}

}
