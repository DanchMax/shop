package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	Item findByName(String name);

	Item findById(int id);

	@Modifying
	@Query("DELETE FROM Item p WHERE p.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);

	@Query("select p from Item p left join fetch p.category left join fetch p.brand left join fetch p.size left join fetch p.star left join fetch p.perman left join fetch p.aging left join fetch p.country")
	List<Item> items();
	
	@Query("select p from Item p left join fetch p.category left join fetch p.brand left join fetch p.size left join fetch p.star left join fetch p.perman left join fetch p.aging left join fetch p.country where p.id=:id")
	Item findOneCategoryBrandSizeStarPermanAgingCountry(@Param("id")int id);
}
