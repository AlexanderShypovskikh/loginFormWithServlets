package com.shypovskikh.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	  private int id;
	  private Date datetime;
	  private String firstName;
	  private String lastName;
	  private String deliveryAddress;
	  private double cost;
	  private List<OrderItem> orderlist;
	
	  
	  public Order(Date datetime, String firstName, String lastName, String deliveryAddress, double cost) {
		super();
		this.datetime = datetime;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deliveryAddress = deliveryAddress;
		this.cost = cost;
		orderlist = new ArrayList();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDatetime() {
		return datetime;
	}


	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDeliveryAddress() {
		return deliveryAddress;
	}


	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}
	  
	  
	  
	  
}
