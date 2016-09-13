package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Size;
import ua.form.SizeFilterForm;

public interface SizeService {

	void save(Size size);

	Size findBySize(String size);

	List<Size> findAll();

	Size findById(int id);

	void delete(int id);

	Size findOne(int id);
	
	Page<Size> findAll(Pageable pageable);
	
	Page<Size> findAll( SizeFilterForm form, Pageable pageable);
}
