package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.service.BrandService;
import ua.service.CategoryService;
import ua.service.CountryService;
import ua.service.ItemService;
import ua.service.KorzinaService;
import ua.service.PermanService;
import ua.service.SizeService;
import ua.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private PermanService permanService;
	
	@Autowired
	private SizeService sizeService;

	@Autowired
	private UserService userService;

}
