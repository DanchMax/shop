package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.Star;
import ua.repository.StarRepository;
import ua.service.StarService;

@Service
public class StarServiceImpl implements StarService {

	@Autowired
	private StarRepository starRepository;

	@Override
	public void save(Star star) {

		starRepository.save(star);
	}

	@Override
	public List<Star> findAll() {
		return starRepository.findAll();
	}

	@Override
	public Star findById(int id) {
		return starRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		starRepository.delete(id);
	}

	@Override
	public Star findOne(int id) {
		return starRepository.findOne(id);
	}

}
