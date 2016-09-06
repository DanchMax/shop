package ua.service;

import java.util.List;

import ua.entity.Star;

public interface StarService {

	void save(Star star);

	List<Star> findAll();

	Star findById(int id);

	void delete(int id);

	Star findOne(int id);
}
