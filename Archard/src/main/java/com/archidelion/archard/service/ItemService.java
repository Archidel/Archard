package com.archidelion.archard.service;

import java.util.List;

import com.archidelion.archard.bean.item.Item;

public interface ItemService {
	void addItemsToInventory(Long characterId, List<Item> list);
}
