package com.shypovskikh.DAO;

import com.shypovskikh.model.User;

public interface SQLiteDAO {
	
	public void addUser(User user);
	public void getUser(String login, String pass);

}
