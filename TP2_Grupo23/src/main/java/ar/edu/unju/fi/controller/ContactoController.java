package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Contactos;


@Controller
@RequestMapping("/")
	public class ContactoController {
	
	/**
	 * Declaro mis objetos inyectados
	 */
	@Autowired
	private Contactos contacto;
	
	/**
	 * @param model  se hace peticion de la pagina
	 * @return  retorno la pagina contacto-form.html
	 */
	@GetMapping("/contacto") 
		public String getContacto(Model model){
		model.addAttribute( "contacto", contacto); //enviar un pbjeto a la pagina, agrega un atributo a la pagina llamada contacto
		return "contacto-form";
	}
	
	/**
	 * @param model  modelo que se utiliza para la vista
	 * @param contacto objeto que representa los datos para rellenar el formulario
	 * @param result objeto que  controla las validaciones de los datos introducidos
	 * @return  el retorno es la pagina contacto-form.html, vista
	 */
	@PostMapping("/contacto")
    public ModelAndView postContacto(Model model ,@Valid @ModelAttribute(value = "contacto") Contactos contacto, BindingResult  result ) {
        ModelAndView modelAndView = new ModelAndView("contacto-form");
        if(result.hasErrors()) {
            System.out.println(contacto.toString());
            modelAndView.setViewName("contacto-form");
            model.addAttribute("contacto-form");
            modelAndView.addObject("contacto", contacto);
            return modelAndView;
        }
        	
            model.addAttribute( "contacto", contacto); //Se envia un nuevo objeto para que se reinicie el formulario. 
            model.addAttribute("datos", "Datos enviados Correctamente");
            System.out.println(contacto.toString()); //Muestro por consola los atributos de contacto.
            return modelAndView;
          
          
	
	}
}
