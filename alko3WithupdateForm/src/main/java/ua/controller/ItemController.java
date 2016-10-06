package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
import ua.form.ItemFilterForm;
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

	@InitBinder("form")
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
	
	@ModelAttribute("filter")
	public ItemFilterForm getFilter(){
		return new ItemFilterForm();
	}

	@RequestMapping("/admin/item")
	public String show(Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") ItemFilterForm form) {
		model.addAttribute("page", itemService.findAll( form, pageable));
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("countrys", countryService.findAll());
		model.addAttribute("permans", permanService.findAll());
		model.addAttribute("sizes", sizeService.findAll());

		return "item";
	}

	@RequestMapping(value = "/admin/item", method = RequestMethod.POST)
	public String save(@ModelAttribute("form") @Valid ItemForm form,
			BindingResult br, Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") ItemFilterForm filter) {
		if (br.hasErrors()) {
			model.addAttribute("page", itemService.findAll(filter, pageable));
			model.addAttribute("categorys", categoryService.findAll());
			model.addAttribute("brands", brandService.findAll());
			model.addAttribute("sizes", sizeService.findAll());
			model.addAttribute("permans", permanService.findAll());
			model.addAttribute("countrys", countryService.findAll());
			return "item";
		}
		itemService.save(form);
		return "redirect:/admin/item"+ getParams( filter, pageable);
	}

	@RequestMapping("/admin/item/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") ItemFilterForm form) {
		itemService.delete(id);
		return "redirect: /admin/item"+getParams( form, pageable);
	}

	@RequestMapping(value = "/admin/item/update/{id}")
	public String update( @PathVariable int id,Model model,@PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") ItemFilterForm form) {
		model.addAttribute("form", itemService.FindForForm(id));
		model.addAttribute("page", itemService.findAll( form, pageable));
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("sizes", sizeService.findAll());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("countrys", countryService.findAll());
		model.addAttribute("permans", permanService.findAll());

		return "item";
	}
	
	private String getParams(ItemFilterForm form, Pageable pageable){
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
			
		}
		
		buffer.append("&min=");
		buffer.append(form.getMin());
		buffer.append("&max=");
		buffer.append(form.getMax());
		for(Integer i : form.getBrandIds()){
			buffer.append("&brandIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getCountryIds()){
			buffer.append("&countryIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getCategoryIds()){
			buffer.append("&categoryIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getPermanIds()){
			buffer.append("&permanIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getSizeIds()){
			buffer.append("&sizeIds=");
			buffer.append(i.toString());
		}
		return buffer.toString();
	}
	
	@RequestMapping("/user/item")
	public String showItemForUser(Model model, @PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") ItemFilterForm form){
		model.addAttribute("page", itemService.findAll(form, pageable));
		model.addAttribute("countrys", countryService.findAll());
		model.addAttribute("brands", brandService.findAll());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("permans", permanService.findAll());
		model.addAttribute("sizes", sizeService.findAll());
		return "userItem";
	}
}
