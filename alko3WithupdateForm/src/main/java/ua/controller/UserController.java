package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.User;
import ua.service.ItemService;
import ua.service.KorzinaService;
import ua.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private KorzinaService korzinaService;

/*	@InitBinder("form")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(User.class, new UserEditor(userService));
	   binder.registerCustomEditor(Role.class, new RoleEditor(roleService));
	   binder.registerCustomEditor(Role.class, new RoleEditor(roleService));
   binder.setValidator(new UserValidator(userService));
	}*/
	
	@ModelAttribute("user")
	public User getForm(){
		return new User();
	}
	
	@RequestMapping("/registration")
	public String register(){
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String save(@ModelAttribute("user") User user){
		userService.save(user);
		return "redirect:/login";
	}

}
