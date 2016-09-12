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

import ua.entity.Role;
import ua.service.RoleService;
import ua.validator.RoleValidator;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("role")
	public Role getRole(){
		return new Role();
	}
	@InitBinder("role")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new RoleValidator(roleService));
	}
	
	@RequestMapping("/admin/role")
	public String show(Model model, @PageableDefault(5) Pageable pageable){
		model.addAttribute("page", roleService.findAll(pageable));
		return "role";
	}
	
	@RequestMapping("/admin/role/delete/{id}")
	public String delete(@PathVariable int id, @RequestParam(value="page", required=false, defaultValue="1") int page, 
			@RequestParam(value="size", required=false, defaultValue="5") int size,
			@RequestParam(value="sort", required=false, defaultValue="") String sort){
		roleService.delete(id);
		return "redirect:/admin/role?page="+page+"&size="+size+"&sort="+sort;
	}
	
	@RequestMapping(value= "/admin/role", method=RequestMethod.POST)
	public String save(@ModelAttribute ("role") @Valid Role role, BindingResult br, Model model) {
		if(br.hasErrors()){
			model.addAttribute("roles", roleService.findAll());
			return "role";
		}
		roleService.save(role);
		return "redirect:/admin/role";
	}
	
	@RequestMapping("/admin/role/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("role", roleService.findById(id));
		model.addAttribute("roles", roleService.findAll());
		return "role";
	}
}
