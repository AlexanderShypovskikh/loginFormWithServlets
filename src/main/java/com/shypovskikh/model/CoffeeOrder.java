package com.shypovskikh.model;

import java.util.Date;

public class CoffeeOrder {
	
	private  Date orderDate; 
	private String name; 
	private String deliveryAddr;
	private double cost;
	
	public CoffeeOrder() {}
	
	public CoffeeOrder(Date orderDate, String name, String deliveryAddr, double cost) {
		super();
		this.orderDate = orderDate;
		this.name = name;
		this.deliveryAddr = deliveryAddr;
		this.cost = cost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	
	
}
