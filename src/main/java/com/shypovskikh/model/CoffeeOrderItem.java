package com.shypovskikh.model;

public class CoffeeOrderItem {
	
	private int type;
	private int quantity;
	private int orderId;
	
	public CoffeeOrderItem() {}
	
	
	public CoffeeOrderItem(int type, int quantity) {
		super();
		this.type = type;
		this.quantity = quantity;
	}
	public CoffeeOrderItem(int type, int quantity, int orderId) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.orderId = orderId;
	}
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	
}
