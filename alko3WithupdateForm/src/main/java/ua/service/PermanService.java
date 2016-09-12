package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Perman;

public interface PermanService {

	void save(Perman perman);

	List<Perman> findAll();

	Perman findById(int id);

	void delete(int id);

	Perman findOne(int id);
	
	Perman findByPerman(String perman);
	Page<Perman> findAll(Pageable pageable);
}
