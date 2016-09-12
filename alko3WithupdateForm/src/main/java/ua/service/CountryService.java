package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Country;

public interface CountryService {

	void save(Country country);

	List<Country> findAll();

	Country findById(int id);

	void delete(int id);

	Country findOne(int id);
	
	Country findByCountry(String country);
	Page<Country> findAll(Pageable pageable);

}
