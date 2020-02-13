package com.qa.persistence.domain;

public class Order {
	private long id;
	private double price;
	private long custId;
	private long itemId;
	private long itemPrice;
	public Order(long id) {
		this.id=id;
		
	}
	public Order(double price,long custId) {
		this.price=price;
		this.custId=custId;
		
	}
	public Order(double price,long custId, long itemId, long itemPrice) {
		this.setItemId(itemId);
		this.price=price;
		this.custId=custId;
		this.setItemPrice(itemPrice);
	}
    
	public Order(long id, long custId, double price) {
		this.id=id;
		this.price=price;
		this.custId=custId;
	}

    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String toString() {
		return "\n"+ "OrderId: " + id + "\n"+ "CustomerId: " + custId +"\n"+ "Price " + price+"\n";
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public long getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(long itemPrice) {
		this.itemPrice = itemPrice;
	}
}
