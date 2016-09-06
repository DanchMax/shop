package ua.service;

import java.util.List;

import ua.entity.Uzer;

public interface UzerService {

	void save(Uzer uzer);

	List<Uzer> uzers();

	List<Uzer> findAll();

	Uzer findById(int id);

	void delete(int id);
}
