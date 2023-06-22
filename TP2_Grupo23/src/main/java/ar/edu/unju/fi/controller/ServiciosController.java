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

import ar.edu.unju.fi.entity.Servicios;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServiciosController {

	@Autowired
	private ICommonService commonService;
	
	
	@Autowired
	private IServicioService servicioService;
	
	/** 
	 * 
	 * Maneja la solicitud GET para la ruta "/lista" y devuelve la vista "servicios".
     * Agrega la lista de servicios al modelo antes de mostar la vista.
	 * @param model se hace peticion de la pagina.
	 * @return  retorna la pagina servicios.htlm.
	 */
	
	@GetMapping("/lista") 
	public String getListaServiciosPage(Model model) {
		model.addAttribute("servicios",servicioService.getLista());
		return "servicios";
	}
	
	/**
	 * 
	 * @param model el modelo utilizado para pasar datos a la vista.
	 * @return retorna a la pagina servivio_nuevo.html.
	 */
	
	@GetMapping("/nuevo")
	public String getNuevoServiciosPage(Model model) {
		boolean edicion=false; /** Esta variable se utiliza para indicar si la vista de "servicio_nuevo" está en modo de edición o no. */
		model.addAttribute("servicio" ,servicioService.getServicio());/**  Agrega el atributo "servicio" al modelo y le asigna el valor de la variable "servicio"*/
		model.addAttribute("edicion",edicion);/**  Agrega el atributo "edicion" al modelo y le asigna el valor de la variable "edicion".*/
		
		model.addAttribute("dias", commonService.getDias());
		
		model.addAttribute("horariosserv", commonService.getHorarioServ());
		return "servicio_nuevo";
	}
	/**
	 * Maneja la solicitud POST para la ruta "/guardar" y devuelve un objeto ModelAndView con la vista y los datos apropiados.
	 * Valida el objeto "servicios" utilizando la anotación @Valid y el resultado de validación se almacena en el parámetro "resultado".
	 * Si hay errores de validación, devuelve la vista "servicio_nuevo" con el objeto "servicios" y los errores de validación.
	 * Si no hay errores de validación, agrega el objeto "servicios" a la lista de servicios y devuelve la vista "servicios" con la lista actualizada de servicios.
	 *
	 * @param servicios el objeto Servicios que se va a guardar.
	 * @param resultado el resultado de la validación del objeto servicios.
	 * @return retorna un objeto ModelAndView con la vista y los datos apropiados.
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarServiciosPage(@Valid @ModelAttribute("servicio")Servicios servicios, BindingResult resultado) {
		ModelAndView modelView = new ModelAndView ("servicios");
		if(resultado.hasErrors()){
			modelView.setViewName("servicio_nuevo");
			modelView.addObject("servicio",servicios);
			
			modelView.addObject("dias", commonService.getDias());
			modelView.addObject("horariosserv", commonService.getHorarioServ());
			return modelView;
		}
		servicioService.guardar(servicios);
		modelView.addObject("servicios",servicioService.getLista());
		return modelView;
	}
	/**
	 * Maneja la solicitud GET para la ruta "/modificar/{paseador}" y devuelve la vista "servicio_nuevo".
	 * Busca un servicio específico utilizando el parámetro "paseador" de la ruta.
	 * Agrega el servicio encontrado al modelo y establece la bandera "edicion" en true antes de renderizar la vista.
	 * 
	 * @param model el modelo utilizado para pasar datos a la vista.
	 * @param paseador el valor del parámetro "paseador" de la ruta.
	 * @return retorna a la pagina de  servicio_nuevo.html.
	 */
	@GetMapping("/modificar/{paseador}")
	public String getModificarServicioPage (Model model ,@PathVariable(value="paseador")String paseador) {
		Servicios servicioEncontrado = servicioService.getBy(paseador);
		boolean edicion=true;
		
		model.addAttribute("servicio",servicioEncontrado);
		model.addAttribute("edicion",edicion);
		
		model.addAttribute("dias", commonService.getDias());
		model.addAttribute("horariosserv", commonService.getHorarioServ()); 
		return "servicio_nuevo";
	}
	/**
	 * Maneja la solicitud POST para la ruta "/modificar" y redirige a la ruta "/servicios/lista".
	 * Modifica un servicio existente con los datos proporcionados en el objeto "servicio".
	 * Si hay errores de validación, devuelve la vista "servicio_nuevo" en modo de edición.
	 * 
	 * @param servicio  el objeto Servicios que se va a modificar.
	 * @param resultado el resultado de la validación del objeto servicio.
	 * @param model el modelo utilizado para pasar datos a la vista.
	 * @return la redirección a la ruta "/servicios/lista"
	 */
	@PostMapping("/modificar")
	public String modificarServicio(@Valid @ModelAttribute("servicio")Servicios servicio, BindingResult resultado,Model model) {
		servicioService.modificar(servicio);
		model.addAttribute("dias", commonService.getDias());
		model.addAttribute("horariosserv", commonService.getHorarioServ());
		if(resultado.hasErrors()){
			boolean edicion=true;/**  Esta variable se utiliza para indicar que la vista "servicio_nuevo" está en modo de edición. */
			model.addAttribute("edicion",edicion);
			return "servicio_nuevo"; /**  Si hay errores de validación, se devuelve la vista "servicio_nuevo" en modo de edición. */
		}
		return "redirect:/servicios/lista";
	}
	/**
	 * Maneja la solicitud GET para la ruta "/eliminar/{paseador}" y redirige a la ruta "/servicios/lista".
	 * Elimina un servicio específico identificado por el parámetro "paseador" de la lista de servicios.
	 * 
	 * @param paseador el valor del parámetro "paseador" de la ruta
	 * @return la redirección a la ruta "/servicios/lista"
	 */
	@GetMapping("/eliminar/{paseador}")
	public String eliminarServicio(@PathVariable(value="paseador")String paseador) {
		Servicios servicioEncontrado = servicioService.getBy(paseador);
		servicioService.eliminar(servicioEncontrado);
		return "redirect:/servicios/lista";
	}
	
}