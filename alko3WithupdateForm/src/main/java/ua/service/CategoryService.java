package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Category;

public interface CategoryService {

	void save(Category category);

	Category findById(int id);

	void delete(int id);

	List<Category> findAll();

	Category findOne(int id);

	Category findByCategory(String category);
	
	Page<Category> findAll(Pageable pageable);
}
