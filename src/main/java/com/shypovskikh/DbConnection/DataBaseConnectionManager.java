package com.shypovskikh.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionManager {

	 private Connection connection; 
	 
	 public DataBaseConnectionManager(String url, String user, String pwd, String driver) {
		
		 try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
