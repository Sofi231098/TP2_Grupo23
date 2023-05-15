package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ContactoController {
	
	@GetMapping("/contacto") 
	public String contacto(){
		return "contacto-form";
	}

}
