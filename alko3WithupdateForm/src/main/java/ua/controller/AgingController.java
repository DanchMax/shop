package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.Aging;
import ua.service.AgingService;

@Controller
public class AgingController {

	@Autowired
	private AgingService agingService;
	
	@ModelAttribute("aging")
	public Aging getAging() {
		return new Aging();
	}
	
	@RequestMapping("/admin/aging")
	public String show(Model model){
		model.addAttribute("agings", agingService.findAll());
		return "aging";
	}
	
	@RequestMapping("/admin/aging/delete/{id}")
	public String delete(@PathVariable int id){
		agingService.delete(id);
		return "redirect:/admin/aging";
	}
	
	/*@RequestMapping(value= "/admin/aging", method=RequestMethod.POST)
	public String save(@RequestParam String title){
		agingService.save(title);
		return "redirect:/admin/aging";
	}*/
	
	@RequestMapping(value="/admin/aging", method=RequestMethod.POST)
	public String save(@ModelAttribute("aging") @Valid Aging aging, BindingResult br, Model model){
		if(br.hasErrors()){
			return "aging";
		}
		agingService.save(aging);
		return "redirect:/admin/aging";
	}
	
	@RequestMapping("/admin/aging/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("aging", agingService.findById(id));
		model.addAttribute("agings", agingService.findAll());
		return "aging";
	}
}
