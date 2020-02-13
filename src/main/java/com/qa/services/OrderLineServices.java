package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.OrderLineDao;

import com.qa.persistence.domain.OrderLine;

public class OrderLineServices implements CrudServices<OrderLine>,  GetOrderItemDetails {
	OrderLineDao<OrderLine> orderLineDao;
	public OrderLineServices(OrderLineDao<OrderLine> orderLineDao) {
		this.orderLineDao = orderLineDao;
	}
	
	@Override
	public List<OrderLine> readAll() {
		return orderLineDao.readAll(); 
	}

	@Override
	public void create(OrderLine t) {
		// TODO Auto-generated method stub
		orderLineDao.create(t);
		
	}

	@Override
	public void update(long id, OrderLine t) {
		// TODO Auto-generated method stub
		orderLineDao.update(id, t);
		
	}

	@Override
	public void delete(OrderLine t) {
		// TODO Auto-generated method stub
		orderLineDao.delete(t);
		
	}

	@Override
	public long getOrderIdForOrderLine(long custId, double price) {
		// TODO Auto-generated method stub
		return orderLineDao.getOrderIdForOrderLine(custId, price);
		
	}
	

}
