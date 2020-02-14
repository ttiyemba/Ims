package com.qa.persistence.domain;

public class Item {
	private long id;
	private String name;
	private double price;
	private long quantity;
	public Item(String name) {
		this.name=name;
	}
	public Item(String name,double price, long quantity) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	public Item(long id,String name,double price,long quantity) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	/**
	 * 
	 * @return item id 
	 */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return itemName
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return item price
	 */
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "\n"+ "ItemId: " + id + "\n"+ "ItemName: " + name +"\n"+ "Price: " + price+"\n"+ "Quantity: " + quantity+"\n" ;
	}
	/**
	 * 
	 * @return item qauntity
	 *
	 */
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
