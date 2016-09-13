package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Brand;
import ua.form.BrandFilterForm;

public interface BrandService {

	void save(Brand brand);

	Brand findById(int id);

	void delete(int id);

	List<Brand> findAll();

	Brand findByBrand(String brand);
	
	Page<Brand> findAll(Pageable pageable);
	
	Page<Brand> findAll( BrandFilterForm form, Pageable pageable);
}
