package com.archidelion.archard.service;

import com.archidelion.archard.bean.User;

public interface UserService {
	User login(String login, String password);

	User addUser(User user);
}
