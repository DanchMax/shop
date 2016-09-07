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

import ua.editor.BrandEditor;
import ua.editor.CategoryEditor;
import ua.editor.CountryEditor;
import ua.editor.PermanEditor;
import ua.editor.SizeEditor;
import ua.entity.Brand;
import ua.entity.Category;
import ua.entity.Country;
import ua.entity.Perman;
import ua.entity.Size;
import ua.form.ItemForm;
import ua.service.BrandService;
import ua.service.CategoryService;
import ua.service.CountryService;
import ua.service.ItemService;
import ua.service.PermanService;
import ua.service.SizeService;
import ua.validator.ItemFormValidator;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private PermanService permanService;

	@Autowired
	private SizeService sizeService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(
				categoryService));
		binder.registerCustomEditor(Country.class, new CountryEditor(
				countryService));
		binder.registerCustomEditor(Perman.class, new PermanEditor(
				permanService));
		binder.registerCustomEditor(Size.class, new SizeEditor(sizeService));
		binder.setValidator(new ItemFormValidator(itemService));
	}

	@ModelAttribute("form")
	public ItemForm getForm() {
		return new ItemForm();
	}

	@RequestMapping("/admin/item")
	public String show(Model model) {
		model.addAttribute("items", itemService.items());

		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("countrys", countryService.findAll());
		model.addAttribute("permans", permanService.findAll());
		model.addAttribute("sizes", sizeService.findAll());

		return "item";
	}

	@RequestMapping(value = "/admin/item", method = RequestMethod.POST)
	public String save(@ModelAttribute("form")@Valid ItemForm form, BindingResult br, Model model){
		if(br.hasErrors()){
			model.addAttribute("items", itemService.items());
			model.addAttribute("categorys", categoryService.findAll());
			model.addAttribute("brands", brandService.findAll());
			model.addAttribute("sizes", sizeService.findAll());
			model.addAttribute("permans", permanService.findAll());
			model.addAttribute("countrys", countryService.findAll());
			return "item";
		}
		itemService.save(form);
		return "redirect:/admin/item";
	}

	@RequestMapping("/admin/item/delete/{id}")
	public String delete(@PathVariable int id) {
		itemService.delete(id);
		return "redirect: /admin/item";
	}

	@RequestMapping(value = "/admin/item/update/{id}")
	public String update(Model model, @PathVariable int id) {
		model.addAttribute("form", itemService.FindForForm(id));
		model.addAttribute("items", itemService.items());

		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("countrys", countryService.findAll());
		model.addAttribute("permans", permanService.findAll());

		return "item";
	}
}
