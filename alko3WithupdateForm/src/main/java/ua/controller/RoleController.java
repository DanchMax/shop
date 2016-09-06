package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.Role;
import ua.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("role")
	public Role getRole(){
		return new Role();
	}
	@RequestMapping("/admin/role")
	public String show(Model model){
		model.addAttribute("roles", roleService.findAll());
		return "role";
	}
	
	@RequestMapping("/admin/role/delete/{id}")
	public String delete(@PathVariable int id){
		roleService.delete(id);
		return "redirect:/admin/role";
	}
	
	@RequestMapping(value= "/admin/role", method=RequestMethod.POST)
	public String save(@ModelAttribute ("role") Role role){
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
