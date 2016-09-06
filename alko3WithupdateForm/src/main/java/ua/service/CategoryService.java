package ua.service;

import java.util.List;

import ua.entity.Category;

public interface CategoryService {

	void save(Category category);

	Category findById(int id);

	void delete(int id);

	List<Category> findAll();

	Category findOne(int id);

	Category findByCategory(String category);
}
