package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.Size;
import ua.service.SizeService;

@Controller
public class SizeController {

	@Autowired
	private SizeService sizeService;
	
	@ModelAttribute("size")
	public Size getSize(){
		return new Size();
	}
	@RequestMapping("/admin/size")
	public String show(Model model){
		model.addAttribute("sizes", sizeService.findAll());
		return "size";
	}
	
	@RequestMapping("/admin/size/delete/{id}")
	public String delete(@PathVariable int id){
		sizeService.delete(id);
		return "redirect:/admin/size";
	}
	
	@RequestMapping(value= "/admin/size", method=RequestMethod.POST)
	public String save(@ModelAttribute ("size") Size size){
		sizeService.save(size);
		return "redirect:/admin/size";
	}
	
	@RequestMapping("/admin/size/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("size", sizeService.findById(id));
		model.addAttribute("sizes", sizeService.findAll());
		return "size";
	}
	
}
