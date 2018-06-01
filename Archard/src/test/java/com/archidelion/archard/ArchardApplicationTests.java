package com.archidelion.archard;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.archidelion.archard.bean.charact.Charact;
import com.archidelion.archard.controller.GameController;
import com.archidelion.archard.service.CharactService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchardApplicationTests {

	private MockMvc mockMvc;

	@Mock
	private CharactService characterService;

	@InjectMocks
	private GameController controller;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).addFilters(new CorsFilter()).build();
	}

	@Test
	public void contextLoads() {
		List<Charact> characters = new ArrayList<Charact>();
		characters.add(new Charact("one"));
		characters.add(new Charact("two"));
		characters.add(new Charact("three"));
		characters.add(new Charact("four"));
	}

}
