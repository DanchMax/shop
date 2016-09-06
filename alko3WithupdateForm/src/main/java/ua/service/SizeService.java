package ua.service;

import java.util.List;

import ua.entity.Size;

public interface SizeService {

	void save(Size size);

	

	List<Size> findAll();

	Size findById(int id);

	void delete(int id);

	Size findOne(int id);
}
