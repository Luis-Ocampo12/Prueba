package org.luis.francisco.service;

import java.util.List;

import org.luis.francisco.entity.Categoria;

public interface IntCategoriasService {
	
	public void guardar(Categoria categoria);
	public List<Categoria> obtenerCategorias();
	public Categoria buscarPorId(Integer idCategoria);
	public void eliminar(Integer idCategoria);
	public int numeroCategorias();
	
	
	
	
	

}
