package com.archidelion.archard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archidelion.archard.bean.item.Item;
import com.archidelion.archard.bean.item.ItemKey;
import com.archidelion.archard.bean.wrapper.ItemRequestWrapper;
import com.archidelion.archard.dao.ItemKeyDao;
import com.archidelion.archard.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemKeyDao itemKeyDao;

	@Override
	public void initialKey(String itemkeys) {
		String[] arrayKeys = itemkeys.split(";");

		if (arrayKeys == null) {
			throw new ServiceException("Array key is null");
		}

		if (arrayKeys.length == 0) {
			throw new ServiceException("Array key is empty");
		}

		List<ItemKey> keyList = new ArrayList<ItemKey>();

		for (String key : arrayKeys) {
			keyList.add(new ItemKey(key.trim()));
		}

		itemKeyDao.saveAll(keyList);
	}

	@Override
	public void addItemToInventory(int characterId, int amount, String itemKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addItemsToInventory(int characterId, ItemRequestWrapper[] itemRequestWrappers) {
		// TODO Auto-generated method stub

	}

}
