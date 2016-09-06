package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.Star;
import ua.service.StarService;

@Controller
public class StarController {

	@Autowired
	private StarService starService;
	
	@ModelAttribute("star")
	public Star getStar() {
		return new Star();
	}
	
	@RequestMapping("/admin/star")
	public String show(Model model){
		model.addAttribute("stars", starService.findAll());
		return "star";
	}
	
	@RequestMapping("/admin/star/delete/{id}")
	public String delete(@PathVariable int id){
		starService.delete(id);
		return "redirect:/admin/star";
	}
	
	@RequestMapping(value= "/admin/star", method=RequestMethod.POST)
	public String save(@ModelAttribute("star") Star star){
		starService.save(star);
		return "redirect:/admin/star";
	}
	
	@RequestMapping("/admin/star/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("star", starService.findById(id));
		model.addAttribute("stars", starService.findAll());
		return "star";
	}
}
