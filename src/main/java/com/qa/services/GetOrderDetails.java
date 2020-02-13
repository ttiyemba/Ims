package com.qa.services;

import java.util.List;

import com.qa.persistence.domain.Item;

public interface GetOrderDetails<T, U, V> {
	long getOrderId(long custId, double price);
	double itemsPrice(U u);
	public List<Item> itemsDisplay();
    long getCustomerId(V v);
    long getItemId(U u);
    List<T> orderDetailsDisplay(long id);

}
