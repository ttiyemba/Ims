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
	@Override
	public long getOrderId(long custId, double price) {
		return orderDao.getOrderId(custId, price);
	}

	@Override
	public List<Order> readAll() {
		return orderDao.readAll();
	}

	@Override
	public void create(Order t) {
		orderDao.create(t);
		
	}

	@Override
	public void update(long id, Order t) {
		orderDao.update(id, t);
		
		
	}

	@Override
	public void delete(Order t) {
		orderDao.delete(t);
		
	}

	@Override
	public double itemsPrice(Item t) {
		
		return orderDao.itemsPrice(t);
	}

	@Override
	public List<Item> itemsDisplay() {
		return orderDao.itemsDisplay();
		
	}

	@Override
	public long getCustomerId(Customer t) {
		return orderDao.getCustomerId(t);
	}

	@Override
	public  long getItemId(Item t) {
		// TODO Auto-generated method stub
		return orderDao.getItemId(t);
	}
	@Override
	public List<Order> orderDetailsDisplay(long id) {
		// TODO Auto-generated method stub
		return orderDao.orderDetailsDisplay(id);
	}
	





}
