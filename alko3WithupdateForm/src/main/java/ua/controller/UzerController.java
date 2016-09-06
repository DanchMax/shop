package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.Uzer;
import ua.service.RoleService;
import ua.service.SexService;
import ua.service.UzerService;

@Controller
public class UzerController {

	@Autowired
	private SexService sexService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UzerService uzerService;

	@ModelAttribute("uzer")
	public Uzer getUzer() {
		return new Uzer();
	}

	@RequestMapping("/admin/uzer")
	public String show(Model model) {
		model.addAttribute("sexs", sexService.findAll());
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("uzers", uzerService.findAll());
		return "uzer";
	}

	@RequestMapping(value = "/admin/uzer", method = RequestMethod.POST)
	public String save(@ModelAttribute("uzer") Uzer uzer) {
		uzerService.save(uzer);
		return "redirect:/admin/uzer";
	}
	
	@RequestMapping("/admin/uzer/delete/{id}")
	public String delete(@PathVariable int id){
		uzerService.delete(id);
		return "uzer";
	}
	@RequestMapping(value = "/admin/uzer/update/{id}")
	public String update(Model model, @PathVariable int id) {
		model.addAttribute("uzer", uzerService.findById(id));
		model.addAttribute("uzers", uzerService.uzers());
		model.addAttribute("roles", roleService.findAll());
		return "uzer";
	}
}
