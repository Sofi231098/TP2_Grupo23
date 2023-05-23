package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.model.Servicios;

@Controller
@RequestMapping("/servicios")
public class ServiciosController {

	ListaServicios listaServicios = new ListaServicios();
	
	@GetMapping("/lista") 
	public String getListaServiciosPage(Model model) {
		model.addAttribute("servicios",listaServicios.getServicios());
		return "servicios";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoServiciosPage(Model model) {
		boolean edicion=false;
		model.addAttribute("servicio",new Servicios());
		model.addAttribute("edicion",edicion);
		return "servicio_nuevo";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarServiciosPage(@ModelAttribute("servicio")Servicios servicios) {
		ModelAndView modelView = new ModelAndView ("servicios");
		listaServicios.getServicios().add(servicios);
		modelView.addObject("servicios",listaServicios.getServicios());
		return modelView;
	}
	
	@GetMapping("/modificar/{paseador}")
	public String getModificarServicioPage (Model model ,@PathVariable(value="paseador")String paseador) {
		Servicios servicioEncontrado = new Servicios();
		boolean edicion=true;
		for(Servicios serv : listaServicios.getServicios()) {
			
			if(serv.getPaseador().equals(paseador)) {
				servicioEncontrado = serv;
				break;
			}
		}
		model.addAttribute("servicio",servicioEncontrado);
		model.addAttribute("edicion",edicion);
		
		return "servicio_nuevo";
	}
	
	@PostMapping("/modificar")
	public String modificarServicio(@ModelAttribute("servico")Servicios servicio) {
		for( Servicios serv: listaServicios.getServicios()) {
			if(serv.getPaseador().equals(servicio.getPaseador())) {
				serv.setTelefono(servicio.getTelefono());
				serv.setDias(servicio.getDias());
				serv.setHorarios(servicio.getHorarios());
			}
		}
		return "redirect:/servicios/lista";
	}
	
	@GetMapping("/eliminar/{paseador}")
	public String eliminarServicio(@PathVariable(value="paseador")String paseador) {
		for(Servicios serv:listaServicios.getServicios()) {
			if(serv.getPaseador().equals(paseador)) {
				listaServicios.getServicios().remove(serv);
				break;
			}
		}
		return "redirect:/servicios/lista";
	}
	
}