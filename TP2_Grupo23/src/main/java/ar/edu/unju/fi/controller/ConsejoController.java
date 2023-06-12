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
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/")
public class ConsejoController { 
	@Autowired
	private IConsejoService consejoService;
	
	
	/*@Autowired 
	private Consejo Consejo;*/
	
	@GetMapping("/consejos")
	public String getConsejosPageString(){
		return "consejos";		
	}
	
	@GetMapping("/consejos/listaConsejo")
	public String getListadoConsejosPage(Model model) {
		model.addAttribute("consejos",  consejoService.getLista());
		return "consejos";
		 
	} 
	
	@GetMapping("/nuevoConsejo")
	public String getNuevoConsejos(Model model) {
		boolean edicion = false;
    	model.addAttribute("consejo",consejoService.getConsejo());
    	model.addAttribute("edicion" , edicion);
		return "consejo_nuevo";
		
		
	}
	
	@PostMapping("/consejos/guardar")
	public ModelAndView getGuardarConsejosPage(@Valid  @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		ModelAndView modelView =new ModelAndView("consejos");
		if(result.hasErrors()) {
			 modelView.setViewName("consejo_nuevo");
			 modelView.addObject("consejo", consejo);
			 return modelView;
		}
		 consejoService.getLista().add(consejo);
		modelView.addObject("consejos",  consejoService.getLista());
		return modelView;
	}
	
	@GetMapping("/consejos/modificar/{titulo}")
	public String getModicarConsejosPage(Model model, @PathVariable(value="titulo")String titulo) {
		Consejo ConsejoEncontrado = consejoService.getBy(titulo);
		boolean edicion = true;
		/*for (Consejo cons :  consejoService.getLista()) {
			if (cons.getTitulo().equals(titulo)) {
				ConsejoEncontrado = cons;
				break;
			}
		}*/
		
		model.addAttribute("consejo", ConsejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "consejo_nuevo";
	}
	
	@PostMapping("/consejos/modificar")
	public String modificarConsejos(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result, Model model) {
		if (result.hasErrors()) {
            boolean edicion=true;
            model.addAttribute("edicion", edicion);
            return "consejo_nuevo";
        }
		
		/*for (Consejo cons:  consejoService.getLista()) {
			if(cons.getTitulo().equals(consejo.getTitulo())) {
			cons.setConsejo(consejo.getConsejo());	
		
		}
	  }*/
		consejoService.modificar(consejo);
		return "redirect:/consejos/listaConsejo";
	}

	
	@GetMapping("/consejos/eliminar/{titulo}")
	public String eliminarConsejos(@PathVariable(value="titulo")String titulo) {
		Consejo consejoEncontrado=consejoService.getBy(titulo);
		consejoService.eliminar(consejoEncontrado);
		return "redirect:/consejos/listaConsejo";
		
	}
	
		
	

}