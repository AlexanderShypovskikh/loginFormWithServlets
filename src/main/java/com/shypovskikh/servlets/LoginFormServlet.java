package com.shypovskikh.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shypovskikh.DAO.DAO;
import com.shypovskikh.DAOImpl.PostgreSQLDAOImpl;
import com.shypovskikh.model.User;

/**
 * Servlet implementation class LoginFormServlet
 */
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFormServlet() {
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
          
		     RequestDispatcher rd;
		    rd = request.getRequestDispatcher("jsp/coffeeList.jsp");
	 		rd.forward(request, response);
	}

}
