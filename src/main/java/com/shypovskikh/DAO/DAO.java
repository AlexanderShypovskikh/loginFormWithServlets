package com.shypovskikh.DAO;

import com.shypovskikh.model.User;

public interface DAO {
	
	public void addUser(User user);
	public User getUser(String login, String pass);

}
