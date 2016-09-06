package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

	Country findByCountry(String country);

	Country findById(int id);

	@Modifying
	@Query("DELETE FROM Country co WHERE co.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}
