package com.qa.persistence.dao;

import java.util.List;


//import com.qa.persistence.domain.Order;

public interface OrderDao<T, U, V>{
    List<T> readAll();
    
    void create(T t);
     
    void update(long id, T t);
     
    void delete(T t);
    
    List<U>itemsDisplay();
    List<T> orderDetailsDisplay(long id);
    double itemsPrice(U u);
    long getCustomerId(V v);
    long getOrderId(long custId, double price);
    long getItemId(U u);
}
