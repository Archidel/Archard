package com.archidelion.archard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.archidelion.archard.bean.User;
import com.archidelion.archard.bean.charact.Charact;
import com.archidelion.archard.service.CharactService;
import com.archidelion.archard.service.UserService;

@RestController
@RequestMapping("/game")
public class GameController {

	@Autowired
	private CharactService charactService;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	@ResponseBody
	public User login(@RequestParam(value = "login", required = true) String login,
			@RequestParam(value = "password", required = true) String password) {

		User user = userService.login(login, password);
		return user;
	}

	@PostMapping("/addCharacter")
	@ResponseBody
	public Charact addCharacter(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "user_id", required = true) int userId) {
		Charact charact = charactService.addCharacter(name, userId);
		return charact;
	}

	@GetMapping("/character/{id}")
	@ResponseBody
	public Charact getCharacterById(@PathVariable String id) {
		Long characterId = Long.parseLong(id);
		Charact charact = charactService.getCharacterById(characterId);
		return charact;
	}

}
