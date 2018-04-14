package com.archidelion.archard.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.archidelion.archard.bean.User;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(TestGameController.class)
public class TestGameController {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private GameController gameController;

	@Test
	public void blaTest() throws Exception {
		User user = new User();
		user.setLogin("Exallted");
		user.setPassword("123456123");
		user.setEmail("albert@gmail.com");
		
		
		given(gameController.login(user.getLogin(), user.getPassword())).willReturn(user);
		
		
	}

}
