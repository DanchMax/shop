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
import ua.entity.Size;
import ua.form.SizeFilterForm;
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
	
	@ModelAttribute("filter")
	public SizeFilterForm getFilter(){
		return new SizeFilterForm();
	}
	
	@InitBinder("size")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new SizeValidator(sizeService));
	}
	@RequestMapping("/admin/size")
	public String show(Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") SizeFilterForm form){
		model.addAttribute("page", sizeService.findAll( form, pageable));
		return "size";
	}
	
	@RequestMapping("/admin/size/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") SizeFilterForm form){
		sizeService.delete(id);
		return "redirect:/admin/size" +getParams( form, pageable);
	}
	
	@RequestMapping(value= "/admin/size", method=RequestMethod.POST)
	public String save(@ModelAttribute ("size") @Valid Size size, BindingResult br, Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") SizeFilterForm form) {
		if(br.hasErrors()){
			model.addAttribute("page", sizeService.findAll( form, pageable));
			return "size";
		}
		sizeService.save(size);
		return "redirect:/admin/size"+ getParams(form, pageable);
	}
	
	@RequestMapping("/admin/size/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") SizeFilterForm form) {
		model.addAttribute("size", sizeService.findById(id));
		model.addAttribute("page", sizeService.findAll(form, pageable));
		return "size";
	}
	
	private String getParams( SizeFilterForm form, Pageable pageable){
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
