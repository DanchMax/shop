package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.User;
import ua.form.UserFilterForm;

public interface UserService {

	void save(User user);

	List<User> users();

	List<User> findAll();

	User findById(int id);
	
	User findByLogin(String login);
	
	User findByMail(String mail);

	void delete(int id);

	Page<User> findAll(Pageable pageable);

	Page<User> findAll(UserFilterForm form, Pageable pageable);
}
