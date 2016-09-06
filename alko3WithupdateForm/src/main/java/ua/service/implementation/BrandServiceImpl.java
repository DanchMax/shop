package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.Brand;
import ua.repository.BrandRepository;
import ua.service.BrandService;

@Service

public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public Brand findById(int id) {
		return brandRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		brandRepository.delete(id);
	}

	@Override
	public Brand findOne(int id) {
		return brandRepository.findOne(id);
	}

	@Override
	public void save(Brand brand) {
		brandRepository.save(brand);
	}



}
