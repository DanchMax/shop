package ua.service;

import java.util.List;

import ua.entity.Role;

public interface RoleService {

	void save(Role role);

	List<Role> findAll();

	Role findById(int id);

	void delete(int id);

}
