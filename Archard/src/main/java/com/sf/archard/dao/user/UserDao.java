package com.sf.archard.dao.user;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sf.archard.model.user.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> getByLoginAndPassword(String login, String password);

	Set<User> findByActivatedTrue();
	
	User getById(Long id);
}
