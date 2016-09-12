package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Role;

public interface RoleService {

	void save(Role role);

	List<Role> findAll();

	Role findById(int id);

	void delete(int id);

	Role findByRole(String role);
	Page<Role> findAll(Pageable pageable);
}
