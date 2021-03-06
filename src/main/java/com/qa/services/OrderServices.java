package com.qa.services;

import java.util.List;

//import com.qa.persistence.dao.ItemDao;
import com.qa.persistence.dao.OrderDao;
import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;

public class OrderServices implements CrudServices<Order>, GetOrderDetails<Order,Item,Customer>,GetCustomerId<Customer>, GetItemId<Item>{
	OrderDao<Order, Item, Customer> orderDao;
	public OrderServices(OrderDao<Order,Item,Customer> orderDao) {
		this.orderDao = orderDao;
	}
	
	public long getOrderId(long custId, double price) {
		return orderDao.getOrderId(custId, price);
	}

	/**
	 * list all order services
	 */
	public List<Order> readAll() {
		return orderDao.readAll();
	}

	/**
	 * create an order service
	 */
	public void create(Order t) {
		orderDao.create(t);
		
	}

	/**
	 * update an order service
	 */
	public void update(long id, Order t) {
		orderDao.update(id, t);
		
		
	}

	
	public void delete(Order t) {
		orderDao.delete(t);
		
	}

	
	public double itemsPrice(Item t) {
		
		return orderDao.itemsPrice(t);
	}

	
	public List<Item> itemsDisplay() {
		return orderDao.itemsDisplay();
		
	}

	
	public long getCustomerId(Customer t) {
		return orderDao.getCustomerId(t);
	}

	
	public  long getItemId(Item t) {
		// TODO Auto-generated method stub
		return orderDao.getItemId(t);
	}
	
	public List<Order> orderDetailsDisplay(long id) {
		// TODO Auto-generated method stub
		return orderDao.orderDetailsDisplay(id);
	}
	





}
