package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Category;
import ua.form.CategoryFilterForm;

public interface CategoryService {

	void save(Category category);

	Category findById(int id);

	void delete(int id);

	List<Category> findAll();

	Category findOne(int id);

	Category findByCategory(String category);
	
	Page<Category> findAll(Pageable pageable);
	
	Page<Category> findAll( CategoryFilterForm form, Pageable pageable);
}
