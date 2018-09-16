package sv.com.jvides.controllers;

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

import sv.com.jvides.models.entities.farmacia;

import sv.com.jvides.models.services.IFarmaciaService;


@Controller
@SessionAttributes("farmacia")
public class farmaciaController {
	@Autowired
	private IFarmaciaService farmaciaService;
	
	@RequestMapping(value="/farmacia", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de Medicamento");
		model.addAttribute("farmacia", farmaciaService.findAll());
		return "farmacia";
	}
	
	@RequestMapping(value="/formfarmacia")
	public String crear(Map<String, Object> model) {
		farmacia farmacia = new farmacia();
		model.put("farmacia", farmacia);
		model.put("titulo", "Formulario de Medicamento");
		return "formfarmacia";
	}
	
		@RequestMapping(value="/formfarmacia", method=RequestMethod.POST)
	public String guardar(@Valid farmacia farmacia, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formfarmacia";
		}
		farmaciaService.save(farmacia);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Medicamento creado con exito");
		return "redirect:farmacia";
	}
		
	@RequestMapping(value="/formfarmacia/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		farmacia farmacia = null;
		if (id > 0) {
			farmacia = farmaciaService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del Medicamento no puede ser cero");
			return "redirect:/farmacia";
		}
		model.put("farmacia", farmacia);
		model.put("titulo", "Editar Medicamento");
		
		return "formfarmacia";
	}
	
	@RequestMapping(value="/eliminarfarmacia/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			farmaciaService.delete(id);
		}
		flash.addFlashAttribute("success","Medicamento eliminado con exito");
		return "redirect:/farmacia";
	}

	@RequestMapping(value="/verfarmacia/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flashl) {
		farmacia farmacia = farmaciaService.findOne(id);
		if (farmacia == null) {
			flashl.addFlashAttribute("error", "El Medicamento no existe en la base de datos");
			return "redirect:/farmacia";
		}

		model.put("farmacia", farmacia);
		model.put("titulo", "Editar Medicamento");
		return "ver";
	}



}
