package com.barberia.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.barberia.springboot.app.models.entity.Barbero;
import com.barberia.springboot.app.models.service.IBarberoService;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/personal")
@SessionAttributes("barbero")
public class barberoController {
	
	@Autowired
	private IBarberoService barberoService;
	
	
	@GetMapping(value = "/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de personal");
		model.addAttribute("barberos", barberoService.findAll());
		return "personal/listar";
	}
	@GetMapping(value = "/dashboard")
	public String principal(Model model) {
		
		return "personal/dashboard";
	}
	

	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Barbero barbero = new Barbero();
		model.put("barbero", barbero);
		model.put("titulo", "Crear barbero");
		return "personal/form";
	}
	
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Barbero barbero = null;
		
		if(id > 0) {
			barbero = barberoService.findOne(id);
			if(barbero == null) {
				flash.addFlashAttribute("error", "El ID del barbero no existe en la BBDD!");
				return "redirect:/personal/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del barbero no puede ser cero!");
			return "redirect:/personal/listar";
		}
		model.put("barbero", barbero);
		model.put("titulo", "Editar Barbero");
		return "personal/form";
	}
	
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Barbero barbero, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear Barbero");
			return "personal/form";
		}
		String mensajeFlash = (barbero.getId() != null)? "Barbero editado con éxito!" : "Barbero creado con éxito!";

		barberoService.save(barbero);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/personal/listar";
	}
	

	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			barberoService.delete(id);
			flash.addFlashAttribute("success", "Barbero eliminado con éxito!");
		}
		return "redirect:/personal/listar";
	}

}
