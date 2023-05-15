package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import ar.edu.unju.fi.controller.form.FormLogin;


@Controller
public class LoginController {
	@GetMapping("/login") 
	public String  login(Model model) {
		FormLogin formlogin = new FormLogin();
		model.addAttribute("formlogin", formlogin);
		return "login";
	}
	
	@PostMapping("/login")
	public String validar(Model model, FormLogin formLogin) {

		if(formLogin.getUsuario().equals("ajax") && formLogin.getPassword().equals("123")) {
			model.addAttribute("usuario", formLogin.getUsuario());
			return "index";
		}else{
			model.addAttribute("error", "acceso incorrecto");
			return "login";
		}
		
	}
	
}
	
