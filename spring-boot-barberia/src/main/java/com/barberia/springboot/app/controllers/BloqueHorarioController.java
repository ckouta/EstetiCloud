package com.barberia.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.barberia.springboot.app.models.entity.BloqueHorario;
import com.barberia.springboot.app.models.service.IBloqueHorarioService;
import com.barberia.springboot.app.models.service.ServicioBloqueHorario;

@Controller
@RequestMapping("/bloquehorario")
//@SessionAttributes

public class BloqueHorarioController {
	@Autowired
	private IBloqueHorarioService servicio ;
	
	@GetMapping(value = "/form")
	public String crearBloque(Map<String,Object> model) {
		BloqueHorario bloque = new BloqueHorario();
		model.put("bloquehorario",bloque);
		model.put("titulo","Crear Bloque");
		return "bloquehorario/form" ;
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardarBloque(@Valid BloqueHorario bloque, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Crear Bloque");
			return "bloquehorario/form" ;
		}
		String mensajeFlash = (bloque.getIdBloque() != null)? "Bloque editado con exito" : "Bloque creado con exito" ;
		
		servicio.save(bloque);
		status.setComplete();
		flash.addFlashAttribute("sucess",mensajeFlash);
		return "redirect:/bloquehorario/listar" ;
	}
	
	@RequestMapping(value = "/form/{idBloque}")
	public String editarBloque(@PathVariable(value="idBloque") Long idBloque, Map<String,Object> model, RedirectAttributes flash) {
		BloqueHorario bloque = null ;
		if(idBloque > 0) {
			bloque = servicio.findOne(idBloque);
			if(bloque == null) {
				flash.addFlashAttribute("error","El Bloque no existe");
				return "redirect:/bloquehorario/listar" ;
			}
		} else {
			flash.addFlashAttribute("error","El Id no puede ser 0");
			return "redirect:/bloquehorario/listar" ;
		}
		model.put("bloque",bloque) ;
		model.put("titulo","Editar Bloque");
		return "bloque/form";
	}
	
	@RequestMapping(value = "/eliminar/{idBloque}")
	public String eliminarBloque(@PathVariable(value="idBloque")Long idBloque, RedirectAttributes flash) {
		if(idBloque > 0) {
			servicio.delete(idBloque);
			flash.addFlashAttribute("sucess","Bloque Eliminado con exito");
		}
		return "redirect:/bloquehorario/listar";
	}
	
	@GetMapping(value = "/listar")
	public String listarBloques(Model model) {
		model.addAttribute("titulo","Lista de Horarios");
		model.addAttribute("bloques",servicio.findAll());
		return "bloquehorario/listar" ;
	}
}
