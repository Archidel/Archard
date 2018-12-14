package com.sf.archard.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.archard.dao.charact.CharactDao;
import com.sf.archard.dao.user.UserDao;
import com.sf.archard.model.charact.Charact;
import com.sf.archard.model.common.Ban;
import com.sf.archard.model.user.User;
import com.sf.archard.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/game/auth")
@Slf4j
public class TestController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CharactDao charactDao;

	@PostMapping("/registr")
	public void logo1ut() {
		User user = new User();
		user.setLogin("testLogin");
		user.setPassword("123456789");
		user.setEmail("test@gmail.com");
		userDao.save(user);
	}

/*	@PostMapping("/addBan")
	public void addBan() {
		User user = userDao.getByLoginAndPassword("testLogin", "123456789");
		Ban ban = new Ban();
		ban.setEndDate(new Date());
		ban.setStartDate(new Date());
		ban.setUser(user);
		user.setBan(ban);
		user.setBanned(true);
		userDao.save(user);
	}

	@PostMapping("/create")
	public void charactCreate() {
		User user = userDao.getByLoginAndPassword("testLogin", "123456789");
		
		Charact charact = new Charact();
		charact.setName("testCharacterName");
		charact.setUser(user);
		charact = charactDao.save(charact);

		// List<Charact> characters = new ArrayList();
		// characters.add(charact);
		// user.setCharacters(characters);
		// userDao.save(user);
	}*/

}
