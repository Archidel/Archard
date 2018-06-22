package com.archidelion.archard.service;

import com.archidelion.archard.bean.User;

public interface UserService {
	User login(String login, String password);

	User addUser(User user);

	static boolean validation(String login, String password) {
		if (validString(login) && validString(password)) {
			return true;
		} else {
			return false;
		}
	}

	static boolean validString(String line) {
		if (line == null || line.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
