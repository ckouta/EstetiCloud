package com.barberia.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.barberia.springboot.app.models.service.IServicioService;
import com.barberia.springboot.app.models.entity.Servicio;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/servicio")
@SessionAttributes("servicio")
public class ServicioController {

	@Autowired
	private IServicioService servicioService;
	 //listar servicios
		@GetMapping(value ="/listar")
		public String listar(Model model) {
			model.addAttribute("titulo", "Listado de reserva");
			model.addAttribute("servicio", servicioService.findAll());
			return "reserva/listar";
		}
	//crear servicio
	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		System.out.print("paso al form");
		Servicio servicio = new Servicio();
		model.put("servicio", servicio);
		model.put("titulo", "Crear reserva");
		return "reserva/form";
	}
	//editar servicio
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Servicio servicio = null;
		
		if(id > 0) {
			servicio = servicioService.findOne(id);
			if(servicio == null) {
				flash.addFlashAttribute("error", "El ID del servicio no existe en la BBDD!");
				return "redirect:/servicio/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del servicio no puede ser cero!");
			return "redirect:/servicio/listar";
		}
		model.put("servicio", servicio);
		model.put("titulo", "Editar servicio");
		return "reserva/form";
	}
	//guardar servicio
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Servicio servicio, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		System.out.print("hora de guardar");
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear reserva");
			return "reserva/form";
		}
		String mensajeFlash = (servicio.getId() != null)? "Servicio editado con éxito!" : "Servicio creado con éxito!";

		servicioService.save(servicio);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/reserva/listar";
	}
	//eliminar servicio
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if(id > 0) {
			servicioService.delete(id);
			flash.addFlashAttribute("success", "Servicio eliminado con éxito!");
		}
		return "redirect:/reserva/listar";
	}
}
