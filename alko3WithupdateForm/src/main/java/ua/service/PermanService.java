package ua.service;

import java.util.List;

import ua.entity.Perman;

public interface PermanService {

	void save(Perman perman);

	List<Perman> findAll();

	Perman findById(int id);

	void delete(int id);

	Perman findOne(int id);

}
