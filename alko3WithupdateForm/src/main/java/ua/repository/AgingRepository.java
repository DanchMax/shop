package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Aging;

public interface AgingRepository extends JpaRepository<Aging, Integer> {

	Aging findByAging(String aging);

	Aging findById(int id);

	@Modifying
	@Query("DELETE FROM Aging a WHERE a.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}
