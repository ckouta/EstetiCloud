package com.barberia.springboot.app.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal != null) {
			flash.addFlashAttribute("info","Hola ya haz iniciado ssesion anteriormente");
			return "redirect:/";
		}
		
		if(error != null) {
			flash.addFlashAttribute("error", "Error: nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
			return "redirect:/login";
		}
		
		if(logout != null) {
			flash.addFlashAttribute("success","Has cerrado sesión con éxito!");
			return "redirect:/login";
		}
		
		return "login";
	}
	
}
