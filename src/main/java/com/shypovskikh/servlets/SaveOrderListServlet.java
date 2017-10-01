package com.shypovskikh.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.shypovskikh.model.CoffeeOrder;
import com.shypovskikh.model.CoffeeOrderItem;

/**
 * Servlet implementation class SaveOrderListServlet
 */
public class SaveOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new PostgreSQLDAOImpl(getConnection(request));
		Timestamp date =  new Timestamp(System.currentTimeMillis());
	    String name = request.getParameter("name");
	    String address = request.getParameter("address");
		//System.out.println("address = "+ address);
	   double cost = (double)request.getServletContext().getAttribute("total");
	//	System.out.println("cost = "+ cost);
		CoffeeOrder  order = new CoffeeOrder(date, name, address, 75);
		CoffeeOrderItem item = new CoffeeOrderItem();
		List<CoffeeOrderItem> items = (ArrayList) request.getServletContext().getAttribute("orderedList");
		int  id = dao.saveCoffeeOrder(order, items);
		
	
		
		//RequestDispatcher rd = request.getRequestDispatcher("jsp/coffeeList.jsp");
		//rd.forward(request, response);
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
