package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Korzina;
import ua.form.KorzinaFilterForm;
import ua.repository.ItemRepository;
import ua.repository.KorzinaRepository;
import ua.repository.UserRepository;
import ua.service.KorzinaService;
import ua.specification.KorzinaFilterAdapter;

@Service

public class KorzinaServiceImpl implements KorzinaService {

	@Autowired
	private KorzinaRepository korzinaRepository;
	

	@Override
	public Korzina findById(int id) {
		return korzinaRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		korzinaRepository.delete(id);
	}

	@Override
	public List<Korzina> findAll() {
		return korzinaRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Korzina form) {
		Korzina korzina = new Korzina();
		korzina.setUser(form.getUser());
		
		korzina.setId(form.getId());
		korzina.setItem(form.getItem());
			korzinaRepository.save(korzina);			
		}

	
	@Override
	public List<Korzina> korzinas() {
		return korzinaRepository.korzinas();
	}

	@Override
	public Page<Korzina> findAll(Pageable pageable) {
		
		return korzinaRepository.findAll(pageable);
	}

	@Override
	public Page<Korzina> findAll(KorzinaFilterForm form, Pageable pageable) {
		
		return korzinaRepository.findAll(new KorzinaFilterAdapter(form) , pageable);
	}
	}


