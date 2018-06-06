package com.archidelion.archard.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.archidelion.archard.bean.item.Item;
import com.archidelion.archard.service.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

	@Mock
	private List<Item> items;
	
	@Spy
	private ItemService itemServiceSpy = new ItemServiceImpl();

	@Mock
	private ItemService itemServiceMock;

	@Test
	public void testAddItemsToInventory_shouldReturnNothin_whenItemListHasZeroListSize() {

	}
	@Test
	public void testAddItemsToInventory_shouldReturnFiveTimes() {

	}

}
