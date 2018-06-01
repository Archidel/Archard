package com.archidelion.archard.service;

import java.util.List;

import com.archidelion.archard.bean.item.Item;

public interface ItemService {
	void initialKey(String itemkeys);

	void saveItemsInInventory(String characterId, List<Item> items);
}
