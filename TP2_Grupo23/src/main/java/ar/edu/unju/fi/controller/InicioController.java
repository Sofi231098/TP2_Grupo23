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

import ar.edu.unju.fi.entity.IndexModel;
import ar.edu.unju.fi.listas.ListaIndex;
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
	 * @param model se hace peticion de la pagina
	 * @return retorno la pagina index.html
	 */
	@GetMapping("/lisInicio")
	public String getIndex(Model model) {
		model.addAttribute("index", listaIndex.getIndex());
		return "index";
	}
	
	
	
	/**
	 * Retorna la vista del formulario para el nuevo objetivo
	 * @param model datos utilizados para la vista
	 * @return  vista para agregar un nuevo objetivo, pagina nuevoo_objetivo.html
	 */
	@GetMapping("/nuevoobj")
	public String getNuevoObjetivo(Model model) {
		boolean edicion = false;
		model.addAttribute("objetivo", objetivo);
		model.addAttribute("edicion" , edicion);
		return "nuevoo_objetivo";
	}
	
	/**
	 * Metodo POST para guardar el objetivo
	 * @param indexModel objeto que representa el objetivo
	 * @param result  objeto que  controla las validaciones de los datos introducidos
	 * @return  el retorno es la pagina index.html, vista
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarObjetivo( @Valid @ModelAttribute("objetivo") IndexModel indexModel, BindingResult  result) {
		ModelAndView modelView = new ModelAndView("index");
		if(result.hasErrors()) {
			modelView.setViewName("nuevoo_objetivo");
			modelView.addObject("objetivo", indexModel);
			return modelView;
		}
		listaIndex.getIndex().add(indexModel);
		modelView.addObject("index", listaIndex.getIndex());
		return modelView;
		
	}
	
	/**
	 * @param model  datos utilizados para la vista
	 * @param objetivos contiene el objetivo que hay que modificar, ubicacion
	 * @return vista para modificar el objetivo
	 */
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
	
	/**
	 * Modifica un objetivo que ya existe
	 * @param indexModel aqui se encuentra el objetivo modificado
	 * @return redirecciona a la pagina index.html despues de la modificacion
	 */
	@PostMapping("/modificar")
	public String modificarObjetivo( @Valid @ModelAttribute("objetivo") IndexModel indexModel, BindingResult result, Model model) { 
		 if(result.hasErrors()){
	            boolean edicion=true;
	            model.addAttribute("edicion", edicion);
	            return "nuevoo_objetivo";
	        }
	   	 for(IndexModel obj: listaIndex.getIndex()) {	
	  			if(obj.getId() == indexModel.getId()) {
	   				obj.setObjetivos(indexModel.getObjetivos());
    				break;
    			}		
	    }
		return "redirect:/inicio/lisInicio";
	} 
	
	/**
//	 * Elimina un objetivo existente.
	 * @param objetivos objeto que contiene el objetivo a eliminar
	 * @return al eliminar se redirecciona a la pagina index.html
	 */
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
