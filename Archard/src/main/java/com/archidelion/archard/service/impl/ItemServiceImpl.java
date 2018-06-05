package com.archidelion.archard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.archidelion.archard.bean.charact.Charact;
import com.archidelion.archard.bean.item.Item;
import com.archidelion.archard.dao.ItemDao;
import com.archidelion.archard.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Transactional
	@Override
	public void addItemsToInventory(Long characterId, List<Item> items) {
		if (items.size() == 0) {
			return;
		}

		for (Item item : items) {
			item.setCharact(new Charact(characterId));
		}

		itemDao.clearInventory(characterId);
		itemDao.saveAll(items);
	}

}
