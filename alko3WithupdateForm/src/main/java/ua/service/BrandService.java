package ua.service;

import java.util.List;

import ua.entity.Brand;

public interface BrandService {

	void save(Brand brand);

	Brand findById(int id);

	void delete(int id);

	List<Brand> findAll();

	Brand findOne(int id);
}
