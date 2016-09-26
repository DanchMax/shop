package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	
	User findById(int id);
	
	User findByLogin(String login);
	
	User findByMail(String mail);

	@Modifying
	@Query("DELETE FROM User u WHERE u.id=:id")
	@Transactional
	void deleteById(@Param("id") int id);
	
	@Query("select u from User u WHERE u.id=:id")
	List<User> users();
	
}
