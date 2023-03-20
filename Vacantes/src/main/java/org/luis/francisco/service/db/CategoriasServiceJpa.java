package org.luis.francisco.service.db;

import java.util.List;
import java.util.Optional;

import org.luis.francisco.entity.Categoria;
import org.luis.francisco.repository.CategoriasRepository;
import org.luis.francisco.service.IntCategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CategoriasServiceJpa implements IntCategoriasService {
	
	@Autowired
	private CategoriasRepository repoCategorias;
	
	@Override
	public void guardar(Categoria categoria) {
		repoCategorias.save(categoria);

	}

	@Override
	public List<Categoria> obtenerCategorias() {
		// TODO Auto-generated method stub
		return repoCategorias.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		Optional<Categoria> optional = repoCategorias.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		repoCategorias.deleteById(idCategoria);
	}

	@Override
	public int numeroCategorias() {
		// TODO Auto-generated method stub
		return (int) repoCategorias.count();
	}

}