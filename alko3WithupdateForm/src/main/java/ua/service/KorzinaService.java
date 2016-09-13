package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Korzina;
import ua.form.KorzinaFilterForm;

public interface KorzinaService {

	void save(Korzina korzina);

	List<Korzina> findAll();

	List<Korzina> korzinas();

	Korzina findById(int id);

	void delete(int id);

	Page<Korzina> findAll(Pageable pageable);
	
	Page<Korzina> findAll( KorzinaFilterForm form, Pageable pageable);
}
