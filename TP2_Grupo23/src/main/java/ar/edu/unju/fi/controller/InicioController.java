package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ar.edu.unju.fi.listas.ListaIndex;
import ar.edu.unju.fi.model.IndexModel;
import jakarta.validation.Valid;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inicio")
public class InicioController {
	
	/**
	 * Declaro mis atributos inyectados
	 */
	
	@Autowired
	 private ListaIndex listaIndex;
	@Autowired
	private IndexModel objetivo;
	
	/**
	 * Controlador GetMapping que me permite devolver la vista '/lisInicio' con el HTML 'index'
	 * @param model
	 * @return
	 */
	@GetMapping("/lisInicio")
	public String getIndex(Model model) {
		model.addAttribute("index", listaIndex.getIndex());
		return "index";
	}
	
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/nuevoobj")
	public String getNuevoObjetivo(Model model) {
		boolean edicion = false;
		model.addAttribute("objetivo", objetivo);
		model.addAttribute("edicion" , edicion);
		return "nuevoo_objetivo";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarObjetivo( @Valid @ModelAttribute("objetivo") IndexModel indexModel, BindingResult  result) {
		ModelAndView modelView = new ModelAndView("index");
		if(result.hasErrors()) {
			modelView.setViewName("nuevoo_objetivo");
			modelView.addObject("objetivo", objetivo);
			return modelView;
		}
		listaIndex.getIndex().add(indexModel);
		modelView.addObject("index", listaIndex.getIndex());
		return modelView;
		
	}
	
	@GetMapping("/modificar/{objetivos}")
	public String getModificarObjetivo(Model model, @PathVariable(value="objetivos") int objetivos) {
		IndexModel objetivoEncontrado = new IndexModel();
		boolean edicion = true;
		for(IndexModel obj : listaIndex.getIndex()) {
			if(obj.getId() == objetivos) {
				objetivoEncontrado = obj;
				break;
			}
		}
		System.out.println(objetivoEncontrado.getId());
		model.addAttribute("objetivo", objetivoEncontrado);
		model.addAttribute("edicion" , edicion);
		return "nuevoo_objetivo";
	}
	
	@PostMapping("/modificar")
	public String modificarObjetivo(@ModelAttribute("objetivo") IndexModel indexModel) { 
		//System.out.println(indexModel.getObjetivos() + indexModel.getId());
		for(IndexModel obj: listaIndex.getIndex()) {
			//System.out.println(obj.getObjetivos() + obj.getId() );
			if(obj.getId() == indexModel.getId()) {
				obj.setObjetivos(indexModel.getObjetivos());
				//System.out.println(obj.getObjetivos());
				break;
			}		
		}
		return "redirect:/inicio/lisInicio";
	} 
	
	@GetMapping("/eliminar/{objetivos}")
	public String eliminarObjetivo(@PathVariable(value="objetivos") int objetivos) {
		//System.out.println(objetivos);
		for(IndexModel obj: listaIndex.getIndex()) {
			//System.out.println(obj.getId() + obj.getObjetivos());
			if(obj.getId() == objetivos){
				listaIndex.getIndex().remove(obj);
			break;
				}
		}
		
		return "redirect:/inicio/lisInicio";
	}

}
