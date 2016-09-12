package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Country;
import ua.repository.CountryRepository;
import ua.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository countryRepository;
	

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public Country findById(int id) {
		return countryRepository.findById(id);
	}

	@Override
	public void delete(int id) {
	countryRepository.delete(id);	
	}

	@Override
	public Country findOne(int id) {
		return countryRepository.findOne(id);
	}

	@Override
	public void save(Country country) {
		countryRepository.save(country);
		
	}

	@Override
	public Country findByCountry(String country) {
		return countryRepository.findByCountry(country);
	}

	@Override
	public Page<Country> findAll(Pageable pageable) {
		
		return countryRepository.findAll(pageable);
	}

}
