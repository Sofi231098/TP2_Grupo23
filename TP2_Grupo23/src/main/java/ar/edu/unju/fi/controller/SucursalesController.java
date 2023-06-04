package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;


/**
 * Controlador para administrar las operaciones relacionadas con las sucursales.
 */

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	
		@Autowired
		private ListaSucursal listaSucursales;
		
		@Autowired
		private Sucursal sucursal;
		
		
		/**
		 * Maneja la solicitud GET para mostrar el listado de sucursales.
		 * 
		 * @param model el modelo para la vista
		 * @return el nombre de la vista "sucursales"
		 */
		
		@GetMapping("/listado") 
		public String getListaSucursalesPage(Model model){
			model.addAttribute("sucursales", listaSucursales.getSucursales());
			return "sucursales";
		}
		
		
		
		/**
		 * Maneja la solicitud GET para mostrar el formulario de creación de una nueva sucursal.
		 * 
		 * @param model el modelo para la vista
		 * @return el nombre de la vista "sucursal_nueva"
		 */
		
		@GetMapping("/nuevo")
		public String getNuevaSucursalPage(Model model) {
			boolean edicion = false;
			model.addAttribute("sucursal", sucursal);
			model.addAttribute("edicion", edicion);
			return "sucursal_nueva";
		}
		
		
		
		/**
		 * Maneja la solicitud POST para guardar una nueva sucursal o actualizar una existente.
		 * 
		 * @param sucursal el objeto Sucursal enviado desde el formulario
		 * @param result el objeto BindingResult para validar el objeto Sucursal
		 * @return un objeto ModelAndView que redirige a la vista "sucursales" si no hay errores de validación, 
		 *         o a la vista "sucursal_nueva" con el objeto Sucursal y los errores de validación si los hay.
		 */
		
		@PostMapping("/guardar")
		public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
			ModelAndView modelView = new ModelAndView("sucursales");
			if (result.hasErrors()) {
				modelView.setViewName("sucursal_nueva");
				modelView.addObject("sucursal", sucursal);
				return modelView;
			}
			listaSucursales.getSucursales().add(sucursal);
			modelView.addObject("sucursales", listaSucursales.getSucursales());
			return modelView;
		}
		
		
		
		/**
		 * Maneja la solicitud GET para mostrar el formulario de modificación de una sucursal existente.
		 * 
		 * @param model el modelo para la vista
		 * @param codigo el código de la sucursal a modificar
		 * @return el nombre de la vista "sucursal_nueva" con el objeto Sucursal a modificar y el indicador de edición
		 */
		
		@GetMapping("/modificar/{codigo}")
		public String getModificarSucursalPage(Model model, @PathVariable(value="codigo")String codigo) {
			Sucursal sucursalEncontrada = new Sucursal() ;
			boolean edicion=true;
			for(Sucursal sucu : listaSucursales.getSucursales()) {
				if(sucu.getCodigo().equals(codigo)) {
					sucursalEncontrada = sucu;
					break;
				}
			}
			model.addAttribute("sucursal", sucursalEncontrada);
			model.addAttribute("edicion", edicion);
			
			return "sucursal_nueva";
		}
		
		
		
		/**
		 * Maneja la solicitud POST para modificar una sucursal existente.
		 * 
		 * @param sucursal el objeto Sucursal enviado desde el formulario
		 * @param result el objeto BindingResult para validar el objeto Sucursal
		 * @param model el modelo para la vista
		 * @return el nombre de la vista "sucursal_nueva" si hay errores de validación,
		 *         o una redirección a la vista "listado" si la modificación fue exitosa
		 */
		
		@PostMapping("/modificar")
		public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result, Model model) {
			
			if (result.hasErrors()) {
				boolean edicion=true;
				model.addAttribute("edicion",edicion);
				return "sucursal_nueva";
			}
			for(Sucursal sucu: listaSucursales.getSucursales()) {
				if(sucu.getNombre().equals(sucursal.getNombre())) {
					sucu.setProvincia(sucursal.getProvincia());
					sucu.setDireccion(sucursal.getDireccion());
					sucu.setTelefono(sucursal.getTelefono());
					sucu.setHorario(sucursal.getHorario());
				}
			}
			return "redirect:/sucursales/listado";
		}
		
		
		
		/**
		 * Maneja la solicitud GET para eliminar una sucursal existente.
		 * 
		 * @param codigo el código de la sucursal a eliminar
		 * @return una redirección a la vista "listado"
		 */
		
		@GetMapping("/eliminar/{codigo}")
		public String eliminarSucursal(@PathVariable(value="codigo") String codigo) {
			for(Sucursal sucu: listaSucursales.getSucursales()) {
				if(sucu.getCodigo().equals(codigo)) {
					listaSucursales.getSucursales().remove(sucu);
					break;
				}
			}
			return "redirect:/sucursales/listado";
		}
		

}
