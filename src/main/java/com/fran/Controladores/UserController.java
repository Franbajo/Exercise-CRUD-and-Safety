package com.fran.Controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fran.Entidad.Alumno;
import com.fran.Entidad.User;
import com.fran.Servicio.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	 @GetMapping("/")
	 public String home() {
	  return "home";
	 }
	 
	 @GetMapping("/registrocompletado")
	 public String registrocompletado() {
	  return "registrocompletado";
	 }
	 
		@GetMapping("/newUser")
		public String agregar(Model model) {
			model.addAttribute("user", new User());
			return "signup";
		}
	 
	 @PostMapping("/saveSignup")
	 public String createUser(@Valid @ModelAttribute ("user") User user, Model model, BindingResult bindingResult) {
	
			 if(bindingResult.hasErrors()) {
				 model.addAttribute("user", user);
		
				 return "signup";
			 } 
			userService.save(user);

		    
			return "registrocompletado";
	 }
}

