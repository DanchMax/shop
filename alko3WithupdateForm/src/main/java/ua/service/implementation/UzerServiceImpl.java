package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.entity.Uzer;
import ua.repository.RoleRepository;
import ua.repository.SexRepository;
import ua.repository.UzerRepository;
import ua.service.UzerService;

@Service

public class UzerServiceImpl implements UzerService {

	@Autowired
	private UzerRepository uzerRepository;
	@Autowired
	private SexRepository sexRepository;
	@Autowired
	private RoleRepository roleRepository;

	public List<Uzer> findAll() {
		return uzerRepository.findAll();
	}

	@Override
	public void delete(int id) {
		uzerRepository.delete(id);
	}

	@Override
	public Uzer findById(int id) {
		return uzerRepository.findById(id);
	}

	@Override
	public void save(Uzer uzer) {
		uzerRepository.save(uzer);
	}

	@Override
	public List<Uzer> uzers() {
		return null;
	}

}
