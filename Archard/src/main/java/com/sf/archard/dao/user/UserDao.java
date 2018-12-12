package com.sf.archard.dao.user;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sf.archard.model.user.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User getByLoginAndPassword(String login, String password);

	@Query("select u from User u where u.banned = 1")
	Set<User> findAllActivated();
}
