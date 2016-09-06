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

import ua.entity.Category;
import ua.service.CategoryService;
import ua.validator.CategoryValidator;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	@InitBinder("category")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new CategoryValidator(categoryService));
	}
	
	@RequestMapping("/admin/category")
	public String show(Model model){
		model.addAttribute("categorys", categoryService.findAll());
		return "category";
	}
	
	@RequestMapping("/admin/category/delete/{id}")
		public String delete(@PathVariable int id){
			categoryService.delete(id);
			return "redirect:/admin/category";
		}
	@RequestMapping(value="/admin/category", method=RequestMethod.POST)
	public String save(@ModelAttribute("category") @Valid Category category, BindingResult br, Model model) {
		if(br.hasErrors()){
			model.addAttribute("categorys", categoryService.findAll());
			return "category";
		}
		categoryService.save(category);
		return "redirect:/admin/category";
	
	}
	
	@RequestMapping("/admin/category/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("category", categoryService.findById(id));
		model.addAttribute("categorys", categoryService.findAll());
		return "category";
	}
}
