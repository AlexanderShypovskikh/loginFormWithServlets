package com.shypovskikh.model;

public class User {
	
	private int id;
	private String login;
	private String pass;
	private String firstName;
	private String lastNmae;
	
	public User() {
		
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
	  
}
