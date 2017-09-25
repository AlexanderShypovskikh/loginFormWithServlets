package com.shypovskikh.model;

public class OrderItem {
	private int id;
	private String typeId;
	private int orderId;
	private int quantity;
	
	
	public OrderItem(String typeId, int orderId, int quantity) {
		super();
		this.typeId = typeId;
		this.orderId = orderId;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTypeId() {
		return typeId;
	}


	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
