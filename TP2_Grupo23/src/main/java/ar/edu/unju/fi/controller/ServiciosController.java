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

import ar.edu.unju.fi.listas.ListaServicios;
import ar.edu.unju.fi.model.Servicios;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServiciosController {

	@Autowired
	ListaServicios listaServicios;
	
	@Autowired
	private Servicios servicio;
	
	/** 
	 * 
	 * Maneja la solicitud GET para la ruta "/lista" y devuelve la vista "servicios".
     * Agrega la lista de servicios al modelo antes de mostar la vista.
	 * @param model se hace peticion de la pagina.
	 * @return  retorna la pagina servicios.htlm.
	 */
	
	@GetMapping("/lista") 
	public String getListaServiciosPage(Model model) {
		model.addAttribute("servicios",listaServicios.getServicios());
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
		model.addAttribute("servicio" ,servicio);/**  Agrega el atributo "servicio" al modelo y le asigna el valor de la variable "servicio"*/
		model.addAttribute("edicion",edicion);/**  Agrega el atributo "edicion" al modelo y le asigna el valor de la variable "edicion".*/
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
			return modelView;
		}
		listaServicios.getServicios().add(servicios);
		modelView.addObject("servicios",listaServicios.getServicios());
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
		if(resultado.hasErrors()){
			boolean edicion=true;/**  Esta variable se utiliza para indicar que la vista "servicio_nuevo" está en modo de edición. */
			model.addAttribute("edicion",edicion);
			return "servicio_nuevo"; /**  Si hay errores de validación, se devuelve la vista "servicio_nuevo" en modo de edición. */
		}
		for( Servicios serv: listaServicios.getServicios()) { /**  Se itera sobre la lista de servicios (listaServicios.getServicios()) para buscar el servicio que coincida con el objeto servicio que se está modificando. */
			if(serv.getPaseador().equals(servicio.getPaseador())) { /**  Se compara el valor del atributo "paseador" de cada servicio con el valor del atributo "paseador" del objeto servicio que se está modificando.*/
				serv.setTelefono(servicio.getTelefono());/** Si se encuentra el servicio correspondiente, se actualizan los datos del servicio */
				serv.setDias(servicio.getDias());
				serv.setHorarios(servicio.getHorarios());
			}
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
		for(Servicios serv:listaServicios.getServicios()) {
			if(serv.getPaseador().equals(paseador)) {
				listaServicios.getServicios().remove(serv);
				break;
			}
		}
		return "redirect:/servicios/lista";
	}
	
}