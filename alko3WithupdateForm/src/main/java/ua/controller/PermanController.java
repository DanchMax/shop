package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Perman;
import ua.service.PermanService;
import ua.validator.PermanValidator;

@Controller
public class PermanController {

	@Autowired
	private PermanService permanService;
	
	@ModelAttribute("perman")
	public Perman getPerman(){
		return new Perman();
	}
	
	@InitBinder("perman")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new PermanValidator(permanService));
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
	public String save(@ModelAttribute("perman") @Valid Perman perman, BindingResult br, Model model) {
		if(br.hasErrors()){
			model.addAttribute("permans", permanService.findAll());
			return "perman";
		}
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
