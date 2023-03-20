package org.luis.francisco.controller;

import java.util.List;

import org.luis.francisco.entity.Categoria;
import org.luis.francisco.service.IntCategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
 
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@GetMapping("/consultar")
	public String buscar(@RequestParam("id") int idCategoria,
				Model model) {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@PostMapping("/guardar")
	public String guardar(Categoria categoria) {
		System.out.println(categoria);
		serviceCategorias.guardar(categoria);
		return "redirect:/categorias/index";
	}
	
	/*@PostMapping("/guardar")
	public String guardarCategoria(@RequestParam("nombre") String nombre,
							@RequestParam("descripcion") String descripcion) {
		Categoria c = new Categoria();
		c.setId(serviceCategorias.obtenerCategorias().size()+1);
		c.setNombre(nombre);
		c.setDescripcion(descripcion);
		serviceCategorias.guardar(c);
		return "redirect:/categorias/index";
	}*/
	
	@GetMapping("/nueva")
	public String nuevaCategoria(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCategoria(@RequestParam("id") int idCategoria,RedirectAttributes model ) {
		model.addFlashAttribute("msg1", "Categoría eliminada");
		serviceCategorias.eliminar(idCategoria);
		return "redirect:/categorias/index";
		
	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> categorias = serviceCategorias.obtenerCategorias();
		model.addAttribute("categorias", categorias);
		model.addAttribute("total", serviceCategorias.numeroCategorias());
		return "categorias/listaCategorias";
	}
}