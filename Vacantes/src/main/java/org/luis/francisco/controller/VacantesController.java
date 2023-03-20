package org.luis.francisco.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.luis.francisco.entity.Vacante;
import org.luis.francisco.service.IntCategoriasService;
import org.luis.francisco.service.IntVacantesService;
import org.luis.francisco.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@Autowired
	private IntVacantesService serviceVacantes;
	
	@GetMapping("/detalles")
	public String detalles(@RequestParam("id") int idVacante , Model model) {
		model.addAttribute("vacante",serviceVacantes.buscarPorId(idVacante) );
		return "vacantes/detalle";
	}
	
	@PostMapping("/guardar")
	public String guardar(Vacante vacante, BindingResult result, @RequestParam("archivoImagen") MultipartFile multiPart, Model model) {
		//System.out.println(vacante);
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
				}
			model.addAttribute("categorias", serviceCategorias.obtenerCategorias());
			return "vacantes/formVacante";
		}
		//************************
		if (!multiPart.isEmpty()) {
			String ruta = "c:/vacantes/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
			// Procesamos la variable nombreImagen
			vacante.setImagen(nombreImagen);
			}
		}
		
		//***************************
		serviceVacantes.guardar(vacante);
		return "redirect:/vacantes/index";
		
	}
	
	@GetMapping("/nueva")
	public String nueva(Vacante vacante, Model model) {
		model.addAttribute("categorias", serviceCategorias.obtenerCategorias());
		return "vacantes/formVacante";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("vacantes", serviceVacantes.obtenerVacantes());
		return "vacantes/listaVacantes";
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) throws IllegalArgumentException{
          setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

        @Override
        public String getAsText() throws IllegalArgumentException {
          return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
        }  
    
      });
  }
}
