package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Size;
import ua.service.SizeService;
import ua.validator.SizeValidator;

@Controller
public class SizeController {

	@Autowired
	private SizeService sizeService;
	
	@ModelAttribute("size")
	public Size getSize(){
		return new Size();
	}
	
	@InitBinder("size")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new SizeValidator(sizeService));
	}
	@RequestMapping("/admin/size")
	public String show(Model model, @PageableDefault(5) Pageable pageable){
		model.addAttribute("page", sizeService.findAll(pageable));
		return "size";
	}
	
	@RequestMapping("/admin/size/delete/{id}")
	public String delete(@PathVariable int id, @RequestParam(value="page", required=false, defaultValue="1") int page, 
			@RequestParam(value="size", required=false, defaultValue="5") int size,
			@RequestParam(value="sort", required=false, defaultValue="") String sort){
		sizeService.delete(id);
		return "redirect:/admin/size?page="+page+"&size="+size+"&sort="+sort;
	}
	
	@RequestMapping(value= "/admin/size", method=RequestMethod.POST)
	public String save(@ModelAttribute ("size") @Valid Size size, BindingResult br, Model model) {
		if(br.hasErrors()){
			model.addAttribute("sizes", sizeService.findAll());
			return "size";
		}
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
