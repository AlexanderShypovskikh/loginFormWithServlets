package com.shypovskikh.DAOImpl;
import com.shypovskikh.model.Coffee;
import com.shypovskikh.model.CoffeeOrder;
import com.shypovskikh.model.CoffeeOrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
	       
	      //  System.out.println("RS = "+rs.getFetchSize());
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

	
	
	@Override
	public int saveCoffeeOrder(CoffeeOrder order, CoffeeOrderItem item) {
	    String query = "insert into CoffeeOrder (order_date, name, delivery_address,cost) values (?,?,?,?)";
	    ResultSet rs = null; 
	    PreparedStatement pstm = null;
	    
	    try {
	    	conn.setAutoCommit(false);
	    	pstm = conn.prepareStatement(query);
	    	pstm.setTimestamp(1, (Timestamp) order.getOrderDate());
	    	pstm.setString(2, order.getName());
	    	pstm.setString(3, order.getDeliveryAddr());
	    	pstm.setDouble(4, order.getCost());
	    	
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
		return 0;
	}

	@Override
	public void saveCoffeeItem(int type, int orderId, int quantity) {
		// TODO Auto-generated method stub
		
	}



}
