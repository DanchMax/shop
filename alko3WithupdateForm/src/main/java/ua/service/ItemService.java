package ua.service;

import java.util.List;

import ua.entity.Item;
import ua.form.ItemForm;

public interface ItemService {

	void save(ItemForm form);

	List<Item> findAll();

	List<Item> items();

	Item findById(int id);
	
	Item findByName(String name);

	void delete(int id);

	ItemForm FindForForm(int id);
	
	
}
