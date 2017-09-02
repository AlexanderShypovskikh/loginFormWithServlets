package com.shypovskikh.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import com.shypovskikh.DAO.SQLiteDAO;
import com.shypovskikh.model.User;

public class SQLiteDAOImpl implements SQLiteDAO{
	private List<User> listData = new ArrayList<User>();
	
	public SQLiteDAOImpl() {
		User user1 = new User("Alex", "123");
		User user2 = new User("Antony", "555");
		listData.add(user1);
		listData.add(user2);
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public User getUser(String login, String pass) {
		 for(User item: listData) {
			 if(item.getLogin().equals(login) && 
					 item.getPass().equals(pass)) 
                return item;         
		 }
		 
		 return null;
		
	}

}
