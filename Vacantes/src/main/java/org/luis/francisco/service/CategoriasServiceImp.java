package org.luis.francisco.service;

import java.util.LinkedList;
import java.util.List;

import org.luis.francisco.entity.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServiceImp implements IntCategoriasService {
	
	private List<Categoria> categorias;
	
	public CategoriasServiceImp() {
		categorias = new LinkedList<>();
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("Ingeniería");
		c1.setDescripcion("Relacionado con diversas áreas de ingeniería");
		
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Programadores web");
		c2.setDescripcion("Relacionado con el desarrollo web");
		
		Categoria c3 = new Categoria();
		c3.setId(3);
		c3.setNombre("Contabilidad");
		c3.setDescripcion("Relacionado con nóminas y auditorías");
		
		categorias.add(c1);
		categorias.add(c2);
		categorias.add(c3);
		categorias.add(c3);

		categorias.add(c3);

	}

	@Override
	public void guardar(Categoria categoria) {
		categorias.add(categoria);
	}

	@Override
	public List<Categoria> obtenerCategorias() {
		return categorias;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria c : categorias) {
			if( c.getId().compareTo(idCategoria) == 0) {
				return c;
			}
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		categorias.remove(buscarPorId(idCategoria));
	}

	@Override
	public int numeroCategorias() {
		// TODO Auto-generated method stub
		return categorias.size();
	}

}
