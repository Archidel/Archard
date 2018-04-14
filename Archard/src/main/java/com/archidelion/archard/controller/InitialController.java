package com.archidelion.archard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.archidelion.archard.service.CharactService;
import com.archidelion.archard.service.ItemService;

@RestController
public class InitialController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private 

	@PostMapping("/game/system/initialitemkeys")
	public void initialItemKeys(@RequestParam(value = "itemkeyId", required = true) String itemKeyId) {
		itemService.initialKeyIds(itemKeyId);
	}

}
