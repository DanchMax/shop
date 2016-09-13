package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Korzina;

public interface KorzinaRepository extends JpaRepository<Korzina, Integer>, JpaSpecificationExecutor<Korzina> {

	@Query("select uo from Korzina uo left join fetch uo.item left join fetch uo.uzer where uo.id=:id")
	Korzina findById(@Param("id") int id);
	
	@Query("select uo from Korzina uo left join fetch uo.item left join fetch uo.uzer")
	List<Korzina> korzinas();

	@Modifying
	@Query("DELETE FROM Korzina uo WHERE uo.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}
