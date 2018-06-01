package com.archidelion.archard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.archidelion.archard.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/game/items/initial")
	public void initialItemKey(@RequestParam(value = "item_keys", required = true) String itemKeys) {
		itemService.initialKey(itemKeys);
	}

	@PostMapping("/game/character/inventory/add/item")
	public void addItemsToInventory(@RequestParam(value = "item_key", required = true) String itemKey,
			@RequestParam(value = "amount", required = true) String itemKe1,
			@RequestParam(value = "item_key", required = true) String itemKe2) {
//		itemService.initialKey(itemKeys);
	}

}
