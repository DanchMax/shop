package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Role;
import ua.repository.RoleRepository;
import ua.service.RoleService;
@Service

public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		roleRepository.delete(id);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
		
	}

	@Override
	public Role findByRole(String role) {
		
		return roleRepository.findByRole(role);
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return roleRepository.findAll(pageable);
	}

}
