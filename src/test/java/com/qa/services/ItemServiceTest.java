package com.qa.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

	@Mock
	private Dao<Item> itemDao;

	@InjectMocks
	private ItemServices itemServices;
	
	Item item = new Item("Chair");

	@Test
	public void itemServicesCreate() {
		Item item = new Item("Chair");
		itemServices.create(item);
		Mockito.verify(itemDao, Mockito.times(1)).create(item);
	}

	@Test
	public void itemServicesRead() {
		itemServices.readAll();
		Mockito.verify(itemDao, Mockito.times(1)).readAll();
	}

	@Test
	public void itemServicesUpdate() {
		Item item = new Item("Chair");
		itemServices.update(1, item);
		Mockito.verify(itemDao, Mockito.times(1)).update(1, item);
	}

	@Test
	public void itemServicesDelete() {
		itemServices.delete(item);
		Mockito.verify(itemDao, Mockito.times(1)).delete(item);
	}
}
