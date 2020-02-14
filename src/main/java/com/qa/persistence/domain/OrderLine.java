package com.qa.persistence.domain;

public class OrderLine {
	private long id;
	private long orderId;
	private long itemId;
	private long quantity;
	/**
	 * Orderline Constructor
	 * @param orderId
	 * @param itemId
	 * @param quantity
	 */
	public OrderLine(long orderId, long itemId, long quantity) {
		this.orderId=orderId;
		this.itemId=itemId;
		this.quantity=quantity;
	}
	public OrderLine(long id, long orderId, long itemId, long quantity) {
		this.orderId=orderId;
		this.itemId=itemId;
		this.quantity=quantity;
	}
	/**
	 * 
	 * @return orderline id
	 */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 
	 * @return itemId
	 */
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	/**
	 * 
	 * @return orderline quantity
	 */
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String toString() {
		return "\n"+ "OrderId " + orderId + "\n"+ "ItemId: " + itemId +"\n"+ "quantity: " + quantity+"\n";
	}
	
}
