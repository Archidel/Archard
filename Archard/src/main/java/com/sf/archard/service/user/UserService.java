package com.sf.archard.service.user;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.archard.common.exception.AuthenticationServiceException;
import com.sf.archard.dao.user.UserDao;
import com.sf.archard.model.user.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User getByLoginAndPassword(String login, String password) {
		return userDao.getByLoginAndPassword(login, password)
				.orElseThrow(() -> new AuthenticationServiceException("Incorrect login or password"));
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public Set<User> findAllActivated() {
		return userDao.findByActivatedTrue();
	}

	public User getById(Long id) {
		return userDao.getById(id);
	}

}
