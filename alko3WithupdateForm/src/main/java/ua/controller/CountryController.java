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

import ua.entity.Country;
import ua.service.CountryService;
import ua.validator.CountryValidator;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@ModelAttribute("country")
	public Country getCountry() {
		return new Country();
	}
	
	@InitBinder("country")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new CountryValidator(countryService));
	}
	
	@RequestMapping("/admin/country")
	public String show(Model model, @PageableDefault(5) Pageable pageable){
		model.addAttribute("page", countryService.findAll(pageable));
		return "country";
	}
	
	@RequestMapping("/admin/country/delete/{id}")
	public String delete(@PathVariable int id, @RequestParam(value="page", required=false, defaultValue="1") int page, 
			@RequestParam(value="size", required=false, defaultValue="5") int size,
			@RequestParam(value="sort", required=false, defaultValue="") String sort){
		countryService.delete(id);
		return "redirect:/admin/country?page="+page+"&size="+size+"&sort="+sort;
	}
	
	@RequestMapping(value= "/admin/country", method=RequestMethod.POST)
	public String save(@ModelAttribute("country") @Valid Country country, BindingResult br, Model model) {
		if(br.hasErrors()){
			model.addAttribute("countrys", countryService.findAll());
			return "country";
		}
		countryService.save(country);
		return "redirect:/admin/country";
	}
	
	@RequestMapping("/admin/country/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("country", countryService.findById(id));
		model.addAttribute("countrys", countryService.findAll());
		return "country";
	}
}
