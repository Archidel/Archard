package com.sf.archard.service.user;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.archard.common.exception.NotFoundException;
import com.sf.archard.dao.user.UserDao;
import com.sf.archard.model.user.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User getByLoginAndPassword(String login, String password) {
		User user = userDao.getByLoginAndPassword(login, password);

		if (user == null) {
			throw new NotFoundException("Incorrect login or password");
		}

		return user;
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public Set<User> findAllActivated() {
		return userDao.findAllActivated();
	}

}
