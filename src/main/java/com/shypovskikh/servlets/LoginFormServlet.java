package com.shypovskikh.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shypovskikh.DAO.SQLiteDAO;
import com.shypovskikh.DAOImpl.SQLiteDAOImpl;
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
         System.out.println("LogintFormServlet...");
		 String login = request.getParameter("login");
		 String pass = request.getParameter("pass"); 
		 System.out.println("login:"+login+" pass:"+pass);
		 SQLiteDAO data = new SQLiteDAOImpl();
         User user =  data.getUser(login, pass);
      
         if(user != null) {
        	 request.setAttribute("user", user);
        	 RequestDispatcher rd = request.getRequestDispatcher("jsp/workpage.jsp");
        	 rd.forward(request, response);
         }
         else {
        	 String message = "There is no user with login:"+login;
        	 request.setAttribute("message", message);
        	 RequestDispatcher rd = request.getRequestDispatcher("jsp/errorMessage.jsp");
        	 rd.forward(request, response);
         }
	}

}
