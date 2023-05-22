package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;


@Controller
@RequestMapping("/sucursales")
public class SucursalesController {
	
		ListaSucursal listaSucursales = new ListaSucursal();
		
		@GetMapping("/listado") 
		public String getListaSucursalesPage(Model model){
			model.addAttribute("sucursales", listaSucursales.getSucursales());
			return "sucursales";
		}
		
		@GetMapping("/nuevo")
		public String getNuevaSucursalPage(Model model) {
			boolean edicion = false;
			model.addAttribute("sucursal", new Sucursal());
			model.addAttribute("edicion", edicion);
			return "sucursal_nueva";
		}
		
		@PostMapping("/guardar")
		public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
			ModelAndView modelView = new ModelAndView("sucursales");
			listaSucursales.getSucursales().add(sucursal);
			modelView.addObject("sucursales", listaSucursales.getSucursales());
			return modelView;
		}
		
		
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
		
		
		@PostMapping("/modificar")
		public String modificarSucursal(@ModelAttribute("sucursal")Sucursal sucursal) {
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
