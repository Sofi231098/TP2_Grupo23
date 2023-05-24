package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;


@Controller
@RequestMapping("/")
public class ConsejoController {
	
	ListaConsejo listaConsejo = new ListaConsejo();
	
	@GetMapping("/consejos")
	public String getConsejosPageString(){
		return "consejos";		
	}
	
	@GetMapping("/consejos/listaConsejo")
	public String getListadoConsejosPage(Model model) {
		model.addAttribute("consejos", listaConsejo.getConsejos());
		return "consejos";
		
	}
	
	@GetMapping("/nuevoConsejo")
	public String getNuevoConsejos(Model model) {
		boolean edicion = false;
    	model.addAttribute("consejos", new Consejo());
    	model.addAttribute("edicion" , edicion);
		return "consejo_nuevo";
		
		
	}
	
	@PostMapping("/consejos/guardar")
	public ModelAndView getGuardarConsejosPage(@ModelAttribute("consejo") Consejo consejo) {
		ModelAndView modelView =new ModelAndView("consejos");
		listaConsejo.getConsejos().add(consejo);
		modelView.addObject("consejos", listaConsejo.getConsejos());
		return modelView;
	}
	
	@GetMapping("/consejos/modificar/{titulo}")
	public String getModicarConsejosPage(Model model, @PathVariable(value="titulo")String titulo) {
		Consejo ConsejoEncontrado = new Consejo();
		boolean edicion = true;
		for (Consejo cons : listaConsejo.getConsejos()) {
			if (cons.getTitulo().equals(titulo)) {
				ConsejoEncontrado = cons;
				break;
			}
		}
		model.addAttribute("consejos", ConsejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "consejo_nuevo";
	}
	
	@PostMapping("/consejos/modificar")
	public String modificarConsejos(@ModelAttribute("consejo") Consejo consejo) {
		
		for (Consejo cons: listaConsejo.getConsejos()) {
			if(cons.getTitulo().equals(consejo.getTitulo())) {
			cons.setConsejo(consejo.getConsejo());	
		
		}
		}
		return "redirect:/consejos/listaConsejo";
	}

	
	@GetMapping("/consejos/eliminar/{titulo}")
	public String eliminarConsejos(@PathVariable(value="titulo")String titulo) {
		for(Consejo cons: listaConsejo.getConsejos()) {
			if(cons.getTitulo().equals(titulo)) {
				listaConsejo.getConsejos().remove(cons);
				break;
				
			}
		}
		return "redirect:/consejos/listaConsejo";
		
	}

}