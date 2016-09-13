package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Integer>, JpaSpecificationExecutor<Size> {

	Size findBySize(String size);

	Size findById(int id);

	@Modifying
	@Query("DELETE FROM Size si WHERE si.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}
