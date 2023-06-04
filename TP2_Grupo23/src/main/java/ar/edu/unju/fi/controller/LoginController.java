package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.controller.form.FormLogin;
import jakarta.validation.Valid;



@Controller
@RequestMapping("/")
public class LoginController {
	
	/**
	 * Declaro mis objetos inyectados
	 */
	@Autowired
	private FormLogin formLogin;
	
	/**
	 * Formulario para el inicio de sesión, vista
	 * @param model datos utilizados para la vista
	 * @return retorna el formulario, pagina login.html
	 */
	@GetMapping({"/","/login"})
	public String  login(Model model) {
		model.addAttribute("formLogin", formLogin);
		return "login";
	}
	
	/**
	 * Validacion de datos para entrar a la pagina
	 * @param model datos utilizados para la vista
	 * @param formLogin objeto que contiene los datos del formulario
	 * @param result  BindingResult contiene los datos de validacion
	 * @return si los datos ingresados son correctos, redirecciona al inicio, si son incorrectos retorna el formulario del pricipio
	 */
	@PostMapping("/login")
	public String validar(  Model model, @Valid FormLogin formLogin, BindingResult  result) {

		if(formLogin.getUsuario().equals("admin") && formLogin.getPassword().equals("123")) {
			model.addAttribute("usuario", formLogin.getUsuario());
			return "redirect:/inicio/lisInicio";
		}
		if(result.hasErrors()) {
			model.addAttribute("login");
			model.addAttribute("formLogin", formLogin);
			return "login";
		}
		  
		   model.addAttribute("error", "Acceso incorrecto"); 
			return "login";
	}
	
}
	
