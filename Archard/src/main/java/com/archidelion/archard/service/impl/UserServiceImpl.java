package com.archidelion.archard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archidelion.archard.bean.User;
import com.archidelion.archard.controller.exception.UserNotFoundException;
import com.archidelion.archard.dao.UserDao;
import com.archidelion.archard.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(String login, String password) {
		User user = userDao.getUserByLoginAndPassword(login, password);

		if (user == null) {
			throw new UserNotFoundException("Wrong login or password");
		}

		return user;
	}

	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}

}
