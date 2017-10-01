package com.shypovskikh.DAO;
import java.util.Date;
import java.util.List;

import com.shypovskikh.model.Coffee;
import com.shypovskikh.model.CoffeeOrder;
import com.shypovskikh.model.CoffeeOrderItem;
import com.shypovskikh.model.User;

public interface DAO {
	
	public void addUser(User user);
	public User getUser(String login, String pass);
	
	public List<Coffee> getCoffeeList();
	
	public int saveCoffeeOrder(CoffeeOrder coffeeOrder, List<CoffeeOrderItem> items);
	
	public void saveCoffeeItem(int type, int orderId, int quantity);

}
