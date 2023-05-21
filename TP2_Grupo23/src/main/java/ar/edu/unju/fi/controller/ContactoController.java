package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.model.Contactos;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/")
	public class ContactoController {
	
	
	@GetMapping("/contacto") 
		public String getContacto(Model model){
	//	Contacto contacto = new Contacto();
		model.addAttribute( "contacto", new Contactos()); //enviar un pbjeto a la pagina, agrega un atributo a la pagina llamada contacto
		return "contacto-form";
	}
	
	@PostMapping("/contacto")
	public String postContacto(Model model, Contactos contacto ) {
		System.out.println(contacto.toString()); //Muestro por consola los atributos de contacto.
		model.addAttribute( "contacto", new Contactos()); //Se envia un nuevo objeto para que se reinicie el formulario. 
		model.addAttribute("datos", "Datos enviados Correctamente");
		return "contacto-form";
		
	}
	
	
}
