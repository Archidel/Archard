package com.archidelion.archard.service.validation;

public final class UserValidation {

	private UserValidation() {
	}

	public static boolean validUser(String login, String password) {
		if (validString(login) && validString(password)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validString(String line) {
		if (line == null || line.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
