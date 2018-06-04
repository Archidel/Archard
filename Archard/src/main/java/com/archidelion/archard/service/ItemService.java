package com.archidelion.archard.service;

import com.archidelion.archard.bean.wrapper.ItemRequestWrapper;

public interface ItemService {
	void initialKey(String itemkeys);

	void addItemToInventory(int characterId, int amount, String itemKey);

	void addItemsToInventory(int characterId, ItemRequestWrapper[] itemRequestWrappers);
}
