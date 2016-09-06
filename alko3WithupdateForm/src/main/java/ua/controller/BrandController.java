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

import ua.entity.Brand;
import ua.service.BrandService;
import ua.validator.BrandValidator;

@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

	@ModelAttribute("brand")
	public Brand getBrand() {
		return new Brand();
	}
	
	@InitBinder("brand")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new BrandValidator(brandService));
	}

	@RequestMapping("/admin/brand")
	public String show(Model model) {
		model.addAttribute("brands", brandService.findAll());
		return "brand";

	}

	@RequestMapping("/admin/brand/delete/{id}")
	public String delete(@PathVariable int id) {
		brandService.delete(id);
		return "redirect:/admin/brand";
	}

	@RequestMapping(value = "/admin/brand", method = RequestMethod.POST)
	public String save(@ModelAttribute("brand") @Valid Brand brand, BindingResult br, Model model) {
		if(br.hasErrors()){
			model.addAttribute("brands", brandService.findAll());
			return "brand";
		}
		brandService.save(brand);
		return "redirect:/admin/brand";
	}

	@RequestMapping("/admin/brand/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("brand", brandService.findById(id));
		model.addAttribute("brands", brandService.findAll());
		return "brand";
	}
}
