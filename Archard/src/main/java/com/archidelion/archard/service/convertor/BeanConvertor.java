package com.archidelion.archard.service.convertor;

import java.util.ArrayList;
import java.util.List;

import com.archidelion.archard.bean.item.Item;
import com.archidelion.archard.bean.wrapper.ItemRequestWrapper;

public final class BeanConvertor {
	private BeanConvertor() {
	}

	public static List<Item> convertItems(ItemRequestWrapper[] itemRequestWrappers) {
		List<Item> items = new ArrayList<Item>();
		for (ItemRequestWrapper itemRequestWrapper : itemRequestWrappers) {
			
			
			items.add(new Item());
		}

		return null;
	}
}
