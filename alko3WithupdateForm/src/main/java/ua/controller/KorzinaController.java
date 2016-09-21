package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.Korzina;
import ua.service.ItemService;
import ua.service.KorzinaService;
import ua.service.UserService;

@Controller
public class KorzinaController {

	@Autowired
	private KorzinaService korzinaService;
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;

	@ModelAttribute("korzina")
	public Korzina getKorzina() {
		return new Korzina();
	}

	@RequestMapping("/admin/korzina")
	public String show(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("korzinas", korzinaService.findAll());
		model.addAttribute("items", itemService.findAll());
		return "korzina";
	}

	@RequestMapping(value = "/admin/korzina", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") Korzina korzina) {
		korzinaService.save(korzina);
		return "redirect:/admin/korzina";
	}

	@RequestMapping("/admin/korzina/delete/{id}")
	public String delete(@PathVariable int id) {
		korzinaService.delete(id);
		return "korzina";
	}

	@RequestMapping(value = "/admin/korzina/update/{id}")
	public String update(Model model, @PathVariable int id) {
		model.addAttribute("korzina", korzinaService.findById(id));
		model.addAttribute("korzinas", korzinaService.korzinas());
		model.addAttribute("items", itemService.findAll());
		model.addAttribute("user", userService.findAll());
		return "korzina";
	}
}
