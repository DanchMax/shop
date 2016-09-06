package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Perman;

public interface PermanRepository extends JpaRepository<Perman, Integer> {

	Perman findByPerman(String perman);

	Perman findById(int id);

	@Modifying
	@Query("DELETE FROM Perman p WHERE p.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}
