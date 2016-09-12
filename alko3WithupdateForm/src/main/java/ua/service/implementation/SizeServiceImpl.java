package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Size;
import ua.repository.SizeRepository;
import ua.service.SizeService;
@Service

public class SizeServiceImpl implements SizeService{

	@Autowired
	private SizeRepository sizeRepository;
	
	@Override
	public List<Size> findAll() {
		return sizeRepository.findAll();
	}

	@Override
	public Size findById(int id) {
		return sizeRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		sizeRepository.delete(id);
	}

	@Override
	public Size findOne(int id) {
		return sizeRepository.findOne(id);
	}

	@Override
	public void save(Size size) {
		sizeRepository.save(size);
		
	}

	@Override
	public Size findBySize(String size) {
		
		return sizeRepository.findBySize(size);
	}

	@Override
	public Page<Size> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return sizeRepository.findAll(pageable);
	}

}
