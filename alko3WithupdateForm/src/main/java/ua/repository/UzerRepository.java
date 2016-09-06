package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Uzer;

public interface UzerRepository extends JpaRepository<Uzer, Integer> {

	@Query("select u from Uzer u left join fetch u.role u left join fetch u.sex where u.id=:id")
	Uzer findById(@Param("id") int id);
	
	Uzer findByName(String name);

	@Modifying
	@Query("DELETE FROM Uzer u WHERE u.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
	
	@Query("select u from Uzer u left join fetch u.role u left join fetch u.sex")
	List<Uzer> uzers();
	
}