package com.archidelion.archard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archidelion.archard.bean.item.ItemKeyId;
import com.archidelion.archard.dao.ItemDao;
import com.archidelion.archard.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public void initialKeyIds(String itemKeyIds) {
		String [] keyids = itemKeyIds.split(",");
		List<ItemKeyId> keyIdList = new ArrayList<ItemKeyId>();
		for(String keyid : keyids) {
			keyIdList.add(new ItemKeyId());
		}
		
		
		
	}

}
