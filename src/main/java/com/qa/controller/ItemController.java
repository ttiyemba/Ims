package com.qa.controller;

import org.apache.log4j.Logger;


import com.qa.persistence.domain.Item;
import com.qa.services.CrudServices;

import com.qa.services.GetItemId;
import com.qa.utils.Utils;

public class ItemController implements CrudController<Item>, GetItemIdController<Item>{
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Item> itemService;
	private GetItemId<Item> getItemId;
	
	
	public ItemController(CrudServices<Item> itemService,GetItemId<Item> getItemId ) {
		this.itemService = itemService;
		this.getItemId=getItemId;
	}
	
	/**
	 * returns list of customers
	 */
	public void readAll() {
		for(Item item: itemService.readAll()) {
			LOGGER.info(item.toString());
		}
	}
	
	/**
	 * create a new item
	 */
	public void create() {
		LOGGER.info("Please enter item name");
		String itemName = Utils.getInput(); 
		while(itemName.matches(".*\\d.*")) {
			LOGGER.info("Please enter item name");
			itemName = Utils.getInput();
		}
		LOGGER.info("Please enter the item price");
		String price= Utils.getInput(); 
		while(price.matches(".*[A-Z a-z].*")) { 
			LOGGER.info("Please enter the item price");
			price = Utils.getInput();
		}
		double itemPrice = Double.parseDouble(price);
		LOGGER.info("Please enter the item quantity");
		String quantity = Utils.getInput();  ;
		while(quantity.matches(".*[A-Z a-z].*")) {
			LOGGER.info("Please enter the item quantity");
			quantity = Utils.getInput();
		}
		long itemQuantity = Long.parseLong(quantity);
		
		itemService.create(new Item(itemName,itemPrice,itemQuantity));
		
	}
	/**
	 * updates a item
	 */

	public void update() {
		LOGGER.info("Hi, it seems you want to change some details, please follow the steps below");
		long itemId= getItemId();
		if(itemId!=0) {
		LOGGER.info("Please enter new or current item name");
		String itemName = Utils.getInput(); 
		while(itemName.matches(".*\\d.*")) {
			LOGGER.info("Please enter new or current item name");
			itemName = Utils.getInput();
		}
		LOGGER.info("Please enter the new or current item price");
		String price= Utils.getInput(); 
		while(price.matches(".*[A-Z a-z].*")) {
			LOGGER.info("Please enter the new or current item price");
			price = Utils.getInput();
		}
		double itemPrice = Double.parseDouble(price);
		LOGGER.info("Please enter the new or current item quantity");
		String quantity = Utils.getInput();  ;
		while(quantity.matches(".*[A-Z a-z].*")) {
			LOGGER.info("Please enter the new or current item quantity");
			quantity = Utils.getInput();
		}
		long itemQuantity = Long.parseLong(quantity);
		
		
		itemService.update(itemId, new Item(itemName,itemPrice,itemQuantity));
		}
	}
	
	/**
	 * delete an item
	 */

	public void delete() {
		LOGGER.info("Please enter the item name");
		String name = Utils.getInput();
		while( name.matches(".*\\d.*")) {
			LOGGER.info("Please enter item name");
			 name = Utils.getInput();
		}
		itemService.delete(new Item(name));
	}
	
	/**
	 * returns a item id
	 */
	
	public long getItemId() {
		LOGGER.info("Please enter the name");
		String itemName = Utils.getInput();
		while(itemName.matches(".*\\d.*")) {
			LOGGER.info("Please enter item name");
			itemName = Utils.getInput();
		}
		long itemId = getItemId.getItemId(new Item(itemName));
	  return itemId;
		
	}


	
}
