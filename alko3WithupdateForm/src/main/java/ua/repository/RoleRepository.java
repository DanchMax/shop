package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRole(String role);

	Role findById(int id);

	@Modifying
	@Query("DELETE FROM Role r WHERE r.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
}