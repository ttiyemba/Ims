package com.qa.services;


import java.util.List;

import com.qa.persistence.dao.ItemDao;
import com.qa.persistence.domain.Item;
public class ItemServices implements CrudServices<Item>, GetItemId<Item>{
	ItemDao<Item> itemDao;
	
	public ItemServices(ItemDao<Item> itemDao) {
		this.itemDao = itemDao;
	}
	
	public List<Item> readAll() {
		return itemDao.readAll();
	}

	public void create(Item item) {
		itemDao.create(item);
	}

	public void update(long id, Item t) {
		itemDao.update(id, t);
	}

	public void delete(Item t) {
		itemDao.delete(t);
	}
	public long getItemId(Item t) {
	
		return itemDao.getItemId(t);
	}
}
