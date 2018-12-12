package com.sf.archard.auth;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.archard.common.exception.AuthenticationServiceException;
import com.sf.archard.model.auth.LoginRequest;
import com.sf.archard.model.user.User;
import com.sf.archard.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/game/auth")
@Slf4j
public class GameAuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public User authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response) throws AuthenticationServiceException {
		return userService.getByLoginAndPassword(loginRequest.getLogin(), loginRequest.getPassword());
	}

	@PostMapping("/logout")
	public void logout() {
		log.debug("logout");
	}

}
