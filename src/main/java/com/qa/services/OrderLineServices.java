package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.OrderLineDao;

import com.qa.persistence.domain.OrderLine;

public class OrderLineServices implements CrudServices<OrderLine>,  GetOrderItemDetails {
	OrderLineDao<OrderLine> orderLineDao;
	public OrderLineServices(OrderLineDao<OrderLine> orderLineDao) {
		this.orderLineDao = orderLineDao;
	}
	
	/**
	 * orderline read all service
	 */
	public List<OrderLine> readAll() {
		return orderLineDao.readAll(); 
	}

	/**
	 * orderLine create service
	 */
	public void create(OrderLine t) {
		
		orderLineDao.create(t);
		
	}

	/**
	 * orderline update service
	 */
	public void update(long id, OrderLine t) {
		
		orderLineDao.update(id, t);
		
	}

	
	public void delete(OrderLine t) {
		
		orderLineDao.delete(t);
		
	}

	
	public long getOrderIdForOrderLine(long custId, double price) {
		
		return orderLineDao.getOrderIdForOrderLine(custId, price);
		
	}
	

}
