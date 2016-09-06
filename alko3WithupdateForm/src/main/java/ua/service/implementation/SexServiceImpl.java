package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Sex;
import ua.repository.SexRepository;
import ua.service.SexService;
@Service

public class SexServiceImpl implements SexService{

	
	@Autowired
	private SexRepository sexRepository;
	
	@Override
	public List<Sex> findAll() {
		return sexRepository.findAll();
	}

	@Override
	public Sex findById(int id) {
		return sexRepository.findById(id);
	}

	@Override
	public void delete(int id) {
	sexRepository.delete(id);	
	}

	@Override
	public void save(Sex sex) {
		sexRepository.save(sex);
		
	}

	@Override
	public Sex findBySex(String sex) {
		
		return sexRepository.findBySex(sex);
	}

}
