package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Chofer;
import com.bolsadeideas.springboot.app.models.service.IChoferService;

@Controller
@SessionAttributes("chofer")
public class ChoferController {

	@Autowired
//	@Qualifier("choferDaoJPA")
//	private IChoferDao choferDao;
	private IChoferService choferService;

//	@GetMapping({ "/", "/listar" })
	@RequestMapping(value = "/listarChofer", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de chofer");
		model.addAttribute("choferes", choferService.findAll());

		return "listarChofer";
	}

	// Mostrar el formulario al usuario
	@RequestMapping(value = "/formChofer")
	public String crear(Map<String, Object> model) {

		Chofer chofer = new Chofer();

		model.put("chofer", chofer);
		model.put("titulo", "Formulario de chofer");
		return "formChofer";
	}

	@RequestMapping(value = "/formChofer/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Chofer chofer = null;
		if (id > 0) {
			chofer = choferService.findOne(id);
			if (chofer == null) {
				flash.addFlashAttribute("error", "El ID del chofer no existe en la BBDD...!");
				return "redirect:/listarChofer";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del chofer no puede ser CERO...!");
			return "redirect:/listarChofer";
		}

//		Chofer chofer = new Chofer();

		model.put("chofer", chofer);
		model.put("titulo", "Formulario de chofer");
		return "formChofer";
	}

	@RequestMapping(value = "/formChofer", method = RequestMethod.POST)
//	public String guardar(@Valid @ModelAttribute("chofer") Chofer chofer, BindingResult result, Model model) {
	public String guardar(@Valid Chofer chofer, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de chofer");
			return "formChofer";
		}
		String mensajeFlash = (chofer.getId() != null) ? "chofer Editado con éxito...!" : "chofer Creado con éxito...!";

		choferService.save(chofer);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listarChofer";
	}

	@RequestMapping(value = "/eliminarChofer/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			choferService.delete(id);
		}
		flash.addFlashAttribute("success", "chofer Eliminado con éxito...!");
		return "redirect:/listarChofer";
	}
	
}
