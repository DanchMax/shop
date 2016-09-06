package ua.service;

import java.util.List;

import ua.entity.Size;

public interface SizeService {

	void save(Size size);

	Size findBySize(String size);

	List<Size> findAll();

	Size findById(int id);

	void delete(int id);

	Size findOne(int id);
}
