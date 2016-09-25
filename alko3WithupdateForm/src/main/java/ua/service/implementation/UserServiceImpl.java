package ua.service.implementation;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.Sex;
import ua.entity.User;
import ua.form.UserFilterForm;
import ua.repository.RoleRepository;
import ua.repository.UserRepository;
import ua.service.UserService;
import ua.specification.UserFilterAdapter;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(int id) {
		userRepository.delete(id);
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public List<User> users() {
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {

		return userRepository.findAll(pageable);
	}

	@Override
	public Page<User> findAll(UserFilterForm form, Pageable pageable) {

		return userRepository.findAll(new UserFilterAdapter(form), pageable);
	}

	@PostConstruct
	public void saveAdmin() {
		User user = userRepository.findOne(1);
		if (user == null) {
			
			user = new User();
			user.setRole(roleRepository.findByRole("admin"));
			user.setSex(Sex.SEX_MALE);
			user.setPassword(encoder.encode("admin"));
			user.setLogin("admin");
			user.setId(1);
			userRepository.save(user);
		}
	}

	@Override
	public User findByLogin(String login) {

		return userRepository.findByLogin(login);
	}

	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByMail(String mail) {
		// TODO Auto-generated method stub
		return userRepository.findByMail(mail);
	}

}
