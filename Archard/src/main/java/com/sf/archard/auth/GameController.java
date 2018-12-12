package com.sf.archard.auth;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.archard.model.charact.Charact;
import com.sf.archard.model.user.User;
import com.sf.archard.service.charact.CharactService;
import com.sf.archard.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/game")
@Slf4j
public class GameController {

	@Autowired
	private CharactService charactService;

	@Autowired
	private UserService userService;

	/*
	 * @PostMapping("/characters") public Charact getCharacters (@Valid @RequestBody
	 * LoginRequest loginRequest) { return
	 * userService.getByLoginAndPassword(loginRequest.getLogin(),
	 * loginRequest.getPassword()); }
	 */

	@GetMapping("/users/{userid}/characters/{charactid}")
	public Charact getUserCharacterById(@PathVariable Long userId, @PathVariable Long charactId) {
		return charactService.getCharacterById(userId, charactId);
	}

	@GetMapping("/users/{id}/characters/")
	public List<Charact> getUserCharacters(@PathVariable Long id) {
		return charactService.getCharacters(id);
	}

	@GetMapping("/users/{id}")
	public List<Charact> getUserById(@PathVariable Long id) {
		return charactService.getCharacters(id);
	}

	@GetMapping("/users/")
	public List<User> getUsers() {
		return userService.findAll();
	}

	@GetMapping("/users/activated")
	public Set<User> getUsersActivated() {
		return userService.findAllActivated();
	}
}
