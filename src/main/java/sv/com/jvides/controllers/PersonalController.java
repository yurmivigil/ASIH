

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

import sv.com.jvides.models.entities.personal;
import sv.com.jvides.models.services.IPersonalService;

@Controller
@SessionAttributes("personal")
public class PersonalController {
	
	@Autowired
	private IPersonalService personalService;
	
	@RequestMapping(value="/personal", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","listado de Personal");
		model.addAttribute("personal", personalService.findAll());
		return "personal";
	}
	
	@RequestMapping(value="/formpersonal")
	public String crear(Map<String, Object> model) {
		personal personal = new personal();
		model.put("personal", personal);
		model.put("titulo", "Formulario de Personal");
		return "formpersonal";
	}
	
		@RequestMapping(value="/formpersonal", method=RequestMethod.POST)
	public String guardar(@Valid personal personal, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		if(bindingResult.hasErrors()) {
			return "formpersonal";
		}
		personalService.save(personal);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Personal creado con exito");
		return "redirect:personal";
	}
		
	@RequestMapping(value="/formpersonal/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		personal personal = null;
		if (id > 0) {
			personal = personalService.findOne(id);
		}else {
			flash.addFlashAttribute("error","El Id del personal no puede ser cero");
			return "redirect:/personal";
		}
		model.put("personal", personal);
		model.put("titulo", "Editar personal");
		
		return "formpersonal";
	}
	
	@RequestMapping(value="/eliminarpersonal/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash) {
		if (id > 0 ) {
			personalService.delete(id);
		}
		flash.addFlashAttribute("success","personal eliminado con exito");
		return "redirect:/personal";
	}

	@RequestMapping(value="/verpersonal/{id}", method=RequestMethod.GET)
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flashl) {
		personal personal = personalService.findOne(id);
		if (personal == null) {
			flashl.addFlashAttribute("error", "El personal no existe en la base de datos");
			return "redirect:/personal";
		}

		model.put("personal", personal);
		model.put("titulo", "Editar personal");
		return "ver";
	}

}
