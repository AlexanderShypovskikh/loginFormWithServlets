package com.shypovskikh.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private int id;
	private String login;
	private String pass;
	private String firstName;
	private String lastName;
	private String role;
	private String address;
	
	public User() {
		
	}
	
	
	public User(int id, String login, String pass, String firstName, String lastNmae, String role, String addr) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastNmae;
		this.role = role;
		this.address = addr;
	}


	public User(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
     public String toString() {
    	 return this.login;
     }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public void setLastName(String lastNmae) {
		this.lastName = lastName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	  
     
     
}
