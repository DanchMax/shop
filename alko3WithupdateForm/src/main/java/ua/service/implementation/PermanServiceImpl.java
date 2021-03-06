package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Perman;
import ua.form.PermanFilterForm;
import ua.repository.PermanRepository;
import ua.service.PermanService;
import ua.specification.PermanFilterAdapter;
@Service
public class PermanServiceImpl implements PermanService{

	@Autowired
	private PermanRepository permanrepository;
	
	@Override
	public List<Perman> findAll() {
		return permanrepository.findAll();
	}

	@Override
	public Perman findById(int id) {
		return permanrepository.findById(id);
	}

	@Override
	public void delete(int id) {
		permanrepository.delete(id);
	}

	@Override
	public Perman findOne(int id) {
		return permanrepository.findOne(id);
	}

	@Override
	public void save(Perman perman) {
		permanrepository.save(perman);
		
	}

	@Override
	public Perman findByPerman(String perman) {
		return permanrepository.findByPerman(perman);
	}

	@Override
	public Page<Perman> findAll(Pageable pageable) {
		
		return permanrepository.findAll(pageable);
	}

	@Override
	public Page<Perman> findAll(PermanFilterForm form, Pageable pageable) {
		
		return permanrepository.findAll(new PermanFilterAdapter(form), pageable);
	}

}
