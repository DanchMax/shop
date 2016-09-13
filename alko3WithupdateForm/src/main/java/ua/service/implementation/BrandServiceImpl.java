package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Brand;
import ua.form.BrandFilterForm;
import ua.repository.BrandRepository;
import ua.service.BrandService;
import ua.specification.BrandFilterAdapter;

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
	public Brand findByBrand(String brand) {
		return brandRepository.findByBrand(brand);
	}

	@Override
	public void save(Brand brand) {
		brandRepository.save(brand);
	}

	@Override
	public Page<Brand> findAll(Pageable pageable) {
		return brandRepository.findAll(pageable);
	}

	@Override
	public Page<Brand> findAll(BrandFilterForm form, Pageable pageable) {

		return brandRepository.findAll(new BrandFilterAdapter(form), pageable);
	}

}
