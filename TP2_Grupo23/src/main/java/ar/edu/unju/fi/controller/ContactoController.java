package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.model.Contactos;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/")
	public class ContactoController {
	
	@Autowired
	private Contactos contacto;
	
	@GetMapping("/contacto") 
		public String getContacto(Model model){
		model.addAttribute( "contacto", contacto); //enviar un pbjeto a la pagina, agrega un atributo a la pagina llamada contacto
		return "contacto-form";
	}
	
	@PostMapping("/contacto")
	public String postContacto(@Valid Model model, Contactos contacto, BindingResult  result ) {
		System.out.println(contacto.toString()); //Muestro por consola los atributos de contacto.
		if(result.hasErrors()) {
			model.addAttribute("contacto-form");
			model.addAttribute( "contacto", contacto);
			 return "contacto-form";
		}
			model.addAttribute( "contacto", contacto); //Se envia un nuevo objeto para que se reinicie el formulario. 
			model.addAttribute("datos", "Datos enviados Correctamente");
			return "contacto-form";
	}
	
	
}
