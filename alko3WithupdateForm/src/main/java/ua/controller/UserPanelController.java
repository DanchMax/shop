package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.ItemService;
import ua.service.KorzinaService;

@Controller
public class UserPanelController {

	@Autowired
	private KorzinaService korzinaService;

	@Autowired
	private ItemService itemService;

	@RequestMapping("/userPanel/userItem")
	public String showProduct(Model model) {
		model.addAttribute("items", itemService.items());
		return "userItems";
	}
}
