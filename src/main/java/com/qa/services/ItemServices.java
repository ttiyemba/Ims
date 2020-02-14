package com.qa.services;


import java.util.List;

import com.qa.persistence.dao.ItemDao;
import com.qa.persistence.domain.Item;
public class ItemServices implements CrudServices<Item>, GetItemId<Item>{
	ItemDao<Item> itemDao;
	
	public ItemServices(ItemDao<Item> itemDao) {
		this.itemDao = itemDao;
	}
	/**
	 * item read all services
	 */
	public List<Item> readAll() {
		return itemDao.readAll();
	}
	
	/**
	 * item create service
	 */
	public void create(Item item) {
		itemDao.create(item);
	}
	/**
	 * item update service
	 */
	public void update(long id, Item t) {
		itemDao.update(id, t);
	}
	/**
	 * item delete service
	 */
	public void delete(Item t) {
		itemDao.delete(t);
	}
	public long getItemId(Item t) {
	
		return itemDao.getItemId(t);
	}
}
