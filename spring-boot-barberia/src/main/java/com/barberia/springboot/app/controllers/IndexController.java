package com.barberia.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.barberia.springboot.app.models.service.IBarberoService;
import com.barberia.springboot.app.models.service.IServicioService;

@Controller
public class IndexController {
	
	@Autowired
	private IBarberoService barberoService;
	
	@Autowired
	private IServicioService servicioService;
	
	@GetMapping("/")
	public String home(Model model) {
		String mensaje="Proyecto Semestral de gestion";
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("barberos", barberoService.findAll());	
		model.addAttribute("servicios", servicioService.findAll());
		return "index";
	}
	
}
