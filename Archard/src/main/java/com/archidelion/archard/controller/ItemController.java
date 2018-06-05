package com.archidelion.archard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.archidelion.archard.bean.charact.Charact;
import com.archidelion.archard.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/game/character/inventory/add/items")
	@ResponseBody
	public void addItemsToInventory(@RequestBody Charact character) {
		itemService.addItemsToInventory(character.getId(), character.getItems());
	}
}
