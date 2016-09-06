package ua.service;

import java.util.List;

import ua.entity.Aging;

public interface AgingService {

	void save(Aging aging);

	Aging findById(int id);

	void delete(int id);

	List<Aging> findAll();

	Aging findOne(int id);
}
