package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Star;

public interface StarRepository extends JpaRepository<Star, Integer> {

	Star findByStar(String star);

	Star findById(int id);

	@Modifying
	@Query("DELETE FROM Star st WHERE st.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);

}
