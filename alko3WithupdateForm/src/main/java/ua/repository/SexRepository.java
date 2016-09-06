package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Sex;

public interface SexRepository extends JpaRepository<Sex, Integer> {

	Sex findBySex(String sex);

	Sex findById(int id);

	@Modifying
	@Query("DELETE FROM Sex s WHERE s.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}
