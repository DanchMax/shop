package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand>{

	Brand findByBrand(String brand);

	Brand findById(int id);

	@Modifying
	@Query("DELETE FROM Brand b WHERE b.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}
