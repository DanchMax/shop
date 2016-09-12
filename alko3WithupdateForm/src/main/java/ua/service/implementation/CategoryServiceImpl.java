package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		categoryRepository.delete(id);
	}

	@Override
	public Category findOne(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category findByCategory(String category) {
		return categoryRepository.findByCategory(category);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

}
