package com.qa.controller;

public interface GetOrderItemDetailsController {
	  
    void readAllOrderLine();
     
    void orderLineCreate(long orderId, long itemId, int quantity);
     
    void orderLineUpdate();
     
    void orderLineDelete();
}
