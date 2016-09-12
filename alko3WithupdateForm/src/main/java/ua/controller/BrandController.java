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
	public String show(Model model, @PageableDefault(5) Pageable pageable) {
		model.addAttribute("page", brandService.findAll(pageable));
		return "brand";

	}

	@RequestMapping("/admin/brand/delete/{id}")
	public String delete(@PathVariable int id, @RequestParam(value="page", required=false, defaultValue="1") int page, 
			@RequestParam(value="size", required=false, defaultValue="5") int size,
			@RequestParam(value="sort", required=false, defaultValue="") String sort) {
		brandService.delete(id);
		return "redirect:/admin/brand?page="+page+"&size="+size+"&sort="+sort;
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
