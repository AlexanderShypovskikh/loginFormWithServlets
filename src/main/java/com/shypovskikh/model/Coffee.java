package com.shypovskikh.model;

public class Coffee {
  private  int id;
  private String typeName;
  private double price;
  private String disabled;
  
  
  
public Coffee(int id, String type_name, double price, String disabled) {
	super();
	this.id = id;
	this.typeName = type_name;
	this.price = price;
	this.disabled = disabled;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTypeName() {
	return typeName;
}
public void setTypeName(String type_name) {
	this.typeName = type_name;
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
	return "Coffee [id=" + id + ", type_name=" + typeName + ", price=" + price + ", disabled=" + disabled
			+ ", getId()=" + getId() + ", getTypeName()=" + getTypeName() + ", getPrice()=" + getPrice()
			+ ", getDisabled()=" + getDisabled() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}
  
  
}
