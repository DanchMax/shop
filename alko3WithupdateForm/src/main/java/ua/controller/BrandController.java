package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.Brand;
import ua.service.BrandService;

@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

	@ModelAttribute("brand")
	public Brand getBrand() {
		return new Brand();
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
	public String save(@ModelAttribute("brand") Brand brand) {
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
