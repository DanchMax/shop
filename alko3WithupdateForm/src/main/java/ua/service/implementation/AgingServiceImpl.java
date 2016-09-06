package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.Aging;
import ua.repository.AgingRepository;
import ua.service.AgingService;

@Service

public class AgingServiceImpl implements AgingService {

	@Autowired
	private AgingRepository agingRepository;

	@Override
	public void save(Aging aging) {
		agingRepository.save(aging);
	}

	@Override
	public List<Aging> findAll() {

		return agingRepository.findAll();
	}

	@Override
	public Aging findById(int id) {
		return agingRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		agingRepository.delete(id);
	}

	

	@Override
	public Aging findOne(int id) {
		return agingRepository.findOne(id);
	}

}
