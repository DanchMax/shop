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
import ua.entity.Perman;
import ua.form.PermanFilterForm;
import ua.service.PermanService;
import ua.validator.PermanValidator;

@Controller
public class PermanController {

	@Autowired
	private PermanService permanService;
	
	@ModelAttribute("perman")
	public Perman getPerman(){
		return new Perman();
	}
	
	@ModelAttribute("filter")
	public PermanFilterForm getFilter(){
		return new PermanFilterForm();
	}
	
	@InitBinder("perman")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new PermanValidator(permanService));
	}
	@RequestMapping("/admin/perman")
	public String show(Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") PermanFilterForm form){
		model.addAttribute("page", permanService.findAll( form, pageable));
		return "perman";
	}
	
	@RequestMapping("/admin/perman/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") PermanFilterForm form){
		permanService.delete(id);
		return "redirect:/admin/perman" +getParams( form, pageable);
	}
	
	@RequestMapping(value= "/admin/perman", method=RequestMethod.POST)
	public String save(@ModelAttribute("perman") @Valid Perman perman, BindingResult br, Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") PermanFilterForm form) {
		if(br.hasErrors()){
			model.addAttribute("page", permanService.findAll( form, pageable));
			return "perman";
		}
		permanService.save(perman);
		return "redirect:/admin/perman"+ getParams(form, pageable);
	}
	
	@RequestMapping("/admin/perman/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") PermanFilterForm form) {
		model.addAttribute("perman", permanService.findById(id));
		model.addAttribute("page", permanService.findAll(form, pageable));
		return "perman";
	}
	private String getParams( PermanFilterForm form, Pageable pageable){
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
		buffer.append("&search=");
		buffer.append(form.getSearch());
		return buffer.toString();
	}
}
