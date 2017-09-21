package com.shypovskikh.DAO;
import java.util.List;

import com.shypovskikh.model.Coffee;
import com.shypovskikh.model.User;

public interface DAO {
	
	public void addUser(User user);
	public User getUser(String login, String pass);
	
	public List<Coffee> getCoffeeList();

}
