package com.shypovskikh.DAOImpl;
import com.shypovskikh.model.Coffee;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.shypovskikh.DAO.DAO;
import com.shypovskikh.model.User;

public class PostgreSQLDAOImpl implements DAO{
	private List<User> listData = new ArrayList<>();
	private List<Coffee> listCoffee = new ArrayList<>();
	private Connection conn = null;
	
	public PostgreSQLDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public User getUser(String login, String pass) {
		 System.out.println("Posgres login = "+login+" pass = "+pass);
		  User user = null;
	      Statement stmt = null;
		  ResultSet rs = null;
		  try {
		  stmt = conn.createStatement();
		  String query = "SELECT users.id, users.email,"
	        		+ " users.first_name, users.last_name,"
	        		+ "users.password,users.address, roles.role_name FROM users"
	        		+" LEFT JOIN roles ON users.id_role = roles.id_role"
	        		+" WHERE users.email = '"+login+"' AND users.password='"+pass+"'";
		    System.out.println(query);
	        rs = stmt.executeQuery(query);
	       
	        System.out.println("RS = "+rs.getFetchSize());
	       
	        while(rs.next()) {
	        int id= rs.getInt("id");
	        String email = rs.getString("email");
	        String fname = rs.getString("first_name");
	        String lname = rs.getString("last_name");
	        String psw = rs.getString("password");
	        String role = rs.getString("role_name");
	        String address = rs.getString("address");
	         user = new User(id, email, psw,fname, lname,role,address);
	        }
	         return user; 
	        }  catch(Exception e) {
			   e.printStackTrace();
		  } finally {
			  if (rs != null) {
			      try { rs.close(); } catch (SQLException e) { ; }
			      rs = null;
			    }
			    if (stmt != null) {
			      try { stmt.close(); } catch (SQLException e) { ; }
			      stmt = null;
			    }
			    if (conn != null) {
			      try { conn.close(); } catch (SQLException e) { ; }
			      conn = null;
			    }
		   }
	       
	 return null;
	}

	public List<Coffee> getCoffeeList() {
		 System.out.println("Select list of coffee...");
		  Statement stmt = null;
		  ResultSet rs = null;
		  try {
		  stmt = conn.createStatement();
		  String query = "SELECT * from coffeetype where disabled is null";
		    System.out.println(query);
	        rs = stmt.executeQuery(query);
	       
	        System.out.println("RS = "+rs.getFetchSize());
	        while(rs.next()) {
	        int id= rs.getInt("id");
	        String name = rs.getString("type_name");
	        double price = rs.getDouble("price");
	        String disabled = rs.getString("disabled");
	        
	         listCoffee.add(new Coffee(id, name, price, disabled));
	        }
	         return listCoffee; 
	        }  catch(Exception e) {
			   e.printStackTrace();
		  } finally {
			  if (rs != null) {
			      try { rs.close(); } catch (SQLException e) { ; }
			      rs = null;
			    }
			    if (stmt != null) {
			      try { stmt.close(); } catch (SQLException e) { ; }
			      stmt = null;
			    }
			    if (conn != null) {
			      try { conn.close(); } catch (SQLException e) { ; }
			      conn = null;
			    }
		   }
	       
		return null;
	}



}
