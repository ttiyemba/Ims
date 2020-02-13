package com.qa.persistence.dao;

import java.util.List;

public interface OrderLineDao<T> {
	 List<T> readAll();
     
	 void create(T t);
	     
	 void update(long id, T t);
	     
	 void delete(T t);
	 
	 long getOrderIdForOrderLine(long custId, double price);

}
