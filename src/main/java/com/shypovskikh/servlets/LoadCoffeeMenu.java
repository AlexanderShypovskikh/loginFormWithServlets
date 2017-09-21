package com.shypovskikh.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.shypovskikh.DAO.DAO;
import com.shypovskikh.DAOImpl.PostgreSQLDAOImpl;
import com.shypovskikh.model.Coffee;
import com.shypovskikh.model.User;

/**
 * Servlet implementation class LoginFormServlet
 */
public class LoadCoffeeMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadCoffeeMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		DAO dao = new PostgreSQLDAOImpl(getConnection(request));
		List<Coffee> listCoffee = dao.getCoffeeList();
		System.out.println(listCoffee.toString());
		request.setAttribute("listCoffee", listCoffee);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/coffeeList.jsp");
		rd.forward(request, response);
	}

	
	private Connection getConnection(HttpServletRequest request) {
		try {
			ServletContext context = getServletContext();
			   DataSource data = (DataSource) context.getAttribute("dataSource");
			   System.out.println("get dataSource = "+data );
		    return   data.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Нельзя создать подключение");
			e.printStackTrace();
		} 
		   return null;
	}
}
