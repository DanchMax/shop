package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.Perman;
import ua.service.PermanService;

@Controller
public class PermanController {

	@Autowired
	private PermanService permanService;
	
	@ModelAttribute("perman")
	public Perman getPerman(){
		return new Perman();
	}
	@RequestMapping("/admin/perman")
	public String show(Model model){
		model.addAttribute("permans", permanService.findAll());
		return "perman";
	}
	
	@RequestMapping("/admin/perman/delete/{id}")
	public String delete(@PathVariable int id){
		permanService.delete(id);
		return "redirect:/admin/perman";
	}
	
	@RequestMapping(value= "/admin/perman", method=RequestMethod.POST)
	public String save(@ModelAttribute("perman") Perman perman){
		permanService.save(perman);
		return "redirect:/admin/perman";
	}
	
	@RequestMapping("/admin/perman/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("perman", permanService.findById(id));
		model.addAttribute("permans", permanService.findAll());
		return "perman";
	}
}
