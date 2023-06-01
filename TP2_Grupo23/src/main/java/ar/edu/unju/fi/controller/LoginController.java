package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.controller.form.FormLogin;


@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private FormLogin formLogin;
	
	@GetMapping("/") 
	public String  login(Model model) {
		//FormLogin formLogin = new FormLogin();
		model.addAttribute("formLogin", formLogin);
		return "login";
	}
	
	@PostMapping("/login")
	public String validar(Model model, FormLogin formLogin) {

		if(formLogin.getUsuario().equals("admin") && formLogin.getPassword().equals("123")) {
			model.addAttribute("usuario", formLogin.getUsuario());
			return "redirect:/inicio/lisInicio";
		}
		
		  
		   model.addAttribute("error", "Acceso incorrecto"); 
			return "login";
	}
	
}
	
