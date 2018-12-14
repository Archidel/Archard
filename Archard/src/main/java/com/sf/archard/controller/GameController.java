package com.sf.archard.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.archard.model.charact.Charact;
import com.sf.archard.model.charact.CharactLocation;
import com.sf.archard.model.charact.CharactStatus;
import com.sf.archard.model.charact.StatPrimary;
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

	@PostMapping("/users/{userId}/characters/{charactId}/status")
	public void updateCharacterStatus(
			@PathVariable Long userId, 
			@PathVariable Long charactId,
			@RequestParam("status") String status) {
		
		log.debug("Updating character status {} for character's {} which has User with id {}", status, charactId, userId);
		charactService.updateStatus(userId, charactId, CharactStatus.valueOf(status.toUpperCase()));
	}
	
	@PostMapping("/users/{userId}/characters/{charactId}/location")
	public void updateCharacterLocation(
			@PathVariable Long userId, 
			@PathVariable Long charactId,
			@RequestBody CharactLocation location) {
		
		log.debug("Updating character location {} for character's {} which has User with id {}", location, charactId, userId);
		charactService.updateLocation(userId, charactId, location);
	}

	@PostMapping("/users/{userId}/characters/{charactId}/stats")
	public void updateStats(
			@PathVariable Long userId, 
			@PathVariable Long charactId,
			@RequestBody List<StatPrimary> stats) {
		
		log.debug("Updating stats {} for character's {} which has User with id {}", stats, charactId, userId);
		charactService.updateStats(userId, charactId, stats);
	}

	@DeleteMapping("/users/{userId}/characters/{charactId}")
	public void deleteCharacterById(@PathVariable Long userId, @PathVariable Long charactId) {
		log.debug("Fetching & Deleting Character with id {} witch has user id: ", charactId, userId);
		charactService.deleteCharacterById(userId, charactId);
	}

	@PutMapping("/users/{userId}/characters/")
	public Charact addCharacter(@PathVariable("userId") long userId, @RequestBody Charact charact) {
		log.debug("Creating Character : {} for user with id: {}", charact, userId);
		return charactService.addCharacter(userId, charact);
	}

	@GetMapping("/users/{userId}/characters/{charactId}")
	public Charact getUserCharacterById(@PathVariable Long userId, @PathVariable Long charactId) {
		log.debug("Fetching Character by id {} and user id {}", charactId, userId);
		return charactService.getCharacterById(userId, charactId);
	}

	@GetMapping("/users/{id}/characters/")
	public List<Charact> getUserCharacters(@PathVariable Long id) {
		log.debug("Fetching user's character list by user id {}", id);
		return charactService.getCharacters(id);
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Long id) {
		log.debug("Fetching User with id {}", id);
		return userService.getById(id);
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
