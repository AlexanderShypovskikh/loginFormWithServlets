package com.shypovskikh.DAOImpl;

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
	private List<User> listData = new ArrayList<User>();
	private Connection conn = null;
	
	public PostgreSQLDAOImpl(Connection conn) {
		User user1 = new User("Alex", "123");
		User user2 = new User("Antony", "555");
		listData.add(user1);
		listData.add(user2);
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
	        		+ "users.password, roles.role_name FROM users"
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
	        
	         user = new User(id, email, psw,fname, lname,role);
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
}
