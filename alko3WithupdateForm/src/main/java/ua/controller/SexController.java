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

import ua.entity.Sex;
import ua.service.SexService;
import ua.validator.SexValidator;

@Controller
public class SexController {

	@Autowired
	private SexService sexService;
	
	@ModelAttribute("sex")
	public Sex getSex(){
		return new Sex();
	}
	
	@InitBinder("sex")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new SexValidator(sexService));
	}
	
	@RequestMapping("/admin/sex")
	public String show(Model model, @PageableDefault(5) Pageable pageable){
		model.addAttribute("page", sexService.findAll(pageable));
		return "sex";
	}
	
	@RequestMapping("/admin/sex/delete/{id}")
	public String delete(@PathVariable int id, @RequestParam(value="page", required=false, defaultValue="1") int page, 
			@RequestParam(value="size", required=false, defaultValue="5") int size,
			@RequestParam(value="sort", required=false, defaultValue="") String sort){
		sexService.delete(id);
		return "redirect:/admin/sex?page="+page+"&size="+size+"&sort="+sort;
	}
	
	@RequestMapping(value= "/admin/sex", method=RequestMethod.POST)
	public String save(@ModelAttribute ("sex") @Valid Sex sex, BindingResult br, Model model) {
		if(br.hasErrors()){
			model.addAttribute("sexs", sexService.findAll());
			return "sex";
		}
		sexService.save(sex);
		return "redirect:/admin/sex";
	}
	
	@RequestMapping("/admin/sex/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("sex", sexService.findById(id));
		model.addAttribute("sexs", sexService.findAll());
		return "sex";
	}
}
