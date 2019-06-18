package com.barberia.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.barberia.springboot.app.models.entity.Cliente;
import com.barberia.springboot.app.models.service.IClienteService;

@Secured("ROLE_USER")
@Controller
@RequestMapping("/cliente")
@SessionAttributes("cliente")
public class clienteController {
	
	@Autowired
	private IClienteService clienteService;
 
	@GetMapping(value = "/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "cliente/listar";
	}

	@GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Crear cliente");
		return "cliente/form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteService.findOne(id);
			if(cliente == null) {
				flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD!");
				return "redirect:/cliente/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/cliente/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "cliente/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear Cliente");
			return "cliente/form";
		}
		String mensajeFlash = (cliente.getId() != null)? "Cliente editado con éxito!" : "Cliente creado con éxito!";

		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/cliente/listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado con éxito!");
		}
		return "redirect:/cliente/listar";
	}

}
