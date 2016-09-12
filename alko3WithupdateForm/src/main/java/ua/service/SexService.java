package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Sex;

public interface SexService {

	void save(Sex sex);

	List<Sex> findAll();

	Sex findById(int id);

	void delete(int id);
	
	Sex findBySex(String sex);
	
	Page<Sex> findAll(Pageable pageable);
}
