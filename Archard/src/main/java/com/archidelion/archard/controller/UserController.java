package com.archidelion.archard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.archidelion.archard.bean.User;
import com.archidelion.archard.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	@ResponseBody
	public User addUser(@RequestBody User user) {
		user = userService.addUser(user);
		System.out.println(user.toString());
		return user;
	}

}
