package com.shypovskikh.model;

public class Coffee {
  private  int id;
  private String type_name;
  private double price;
  private String disabled;
  
  
  
public Coffee(int id, String type_name, double price, String disabled) {
	super();
	this.id = id;
	this.type_name = type_name;
	this.price = price;
	this.disabled = disabled;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType_name() {
	return type_name;
}
public void setType_name(String type_name) {
	this.type_name = type_name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDisabled() {
	return disabled;
}
public void setDisabled(String disabled) {
	this.disabled = disabled;
}
@Override
public String toString() {
	return "Coffee [id=" + id + ", type_name=" + type_name + ", price=" + price + ", disabled=" + disabled
			+ ", getId()=" + getId() + ", getType_name()=" + getType_name() + ", getPrice()=" + getPrice()
			+ ", getDisabled()=" + getDisabled() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
  
  
}
