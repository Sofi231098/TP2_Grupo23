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

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;



/**
 * Controlador para manejar las operaciones relacionadas con las sucursales.
 */
@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	
		@Autowired
		private ISucursalService sucursalService;
		@Autowired
		private ICommonService commonService;
		
		
		
		/**
		 * Método GET para obtener la página de listado de sucursales.
		 * 
		 * @param model modelo para enviar datos a la vista
		 * @return nombre de la vista "sucursales"
		 */
		@GetMapping("/listado") 
		public String getListaSucursalesPage(Model model){
			model.addAttribute("sucursales", sucursalService.getLista());
			return "sucursales";
		}
		
		
		
		
		/**
		 * Método GET para obtener la página de creación de una nueva sucursal.
		 * 
		 * @param model modelo para enviar datos a la vista
		 * @return nombre de la vista "sucursal_nueva"
		 */
		@GetMapping("/nuevo")
		public String getNuevaSucursalPage(Model model) {
			boolean edicion = false;
			model.addAttribute("sucursal", sucursalService.getSucursal());
			model.addAttribute("provincias", commonService.getProvincias());
			model.addAttribute("horarios", commonService.getHorarioSuc());
			model.addAttribute("edicion", edicion);
			return "sucursal_nueva";
		}
		
		
		
		
		/**
		 * Método POST para guardar una nueva sucursal.
		 * 
		 * @param sucursal objeto de la clase Sucursal a guardar
		 * @param result objeto BindingResult para validar los datos de entrada
		 * @return objeto ModelAndView con la vista "sucursales" y la lista actualizada de sucursales
		 */
		@PostMapping("/guardar")
		public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
			ModelAndView modelView = new ModelAndView("sucursales");
			if (result.hasErrors()) {
				modelView.setViewName("sucursal_nueva");
				modelView.addObject("provincias", commonService.getProvincias());
				modelView.addObject("horarios", commonService.getHorarioSuc());
				modelView.addObject("sucursal", sucursal);
				return modelView;
			}
			sucursalService.guardar(sucursal);
			modelView.addObject("sucursales", sucursalService.getLista());
			return modelView;
		}
		
		
		
		
		/**
		 * Método GET para obtener la página de modificación de una sucursal existente.
		 * 
		 * @param model modelo para enviar datos a la vista
		 * @param codigo código de la sucursal a modificar
		 * @return nombre de la vista "sucursal_nueva"
		 */
		@GetMapping("/modificar/{codigo}")
		public String getModificarSucursalPage(Model model, @PathVariable(value="codigo")String codigo) {
			Sucursal sucursalEncontrada = sucursalService.getBy(codigo) ;
			boolean edicion=true;

			model.addAttribute("sucursal", sucursalEncontrada);
			model.addAttribute("provincias", commonService.getProvincias());
			model.addAttribute("horarios", commonService.getHorarioSuc());
			model.addAttribute("edicion", edicion);
			
			return "sucursal_nueva";
		}
		
		
		
		
		/**
		 * Método POST para modificar una sucursal existente.
		 * 
		 * @param sucursal objeto de la clase Sucursal a modificar
		 * @param result objeto BindingResult para validar los datos de entrada
		 * @param model modelo para enviar datos a la vista
		 * @return nombre de la vista "sucursal_nueva" en caso de error, o redireccionamiento a "/sucursales/listado" en caso de éxito
		 */
		@PostMapping("/modificar")
		public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result, Model model) {
			sucursalService.modificar(sucursal);
			model.addAttribute("provincias", commonService.getProvincias());
			model.addAttribute("horarios", commonService.getHorarioSuc());
			if (result.hasErrors()) {
				boolean edicion=true;
				model.addAttribute("edicion",edicion);
				return "sucursal_nueva";
			}
			return "redirect:/sucursales/listado";
		}
		
		
		
		
		/**
		 * Método GET para eliminar una sucursal existente.
		 * 
		 * @param codigo código de la sucursal a eliminar
		 * @return redireccionamiento a "/sucursales/listado"
		 */
		@GetMapping("/eliminar/{codigo}")
		public String eliminarSucursal(@PathVariable(value="codigo") String codigo) {
			Sucursal sucursalEncontrada = sucursalService.getBy(codigo);
			sucursalService.eliminar(sucursalEncontrada);
			return "redirect:/sucursales/listado";
		}
		

}
