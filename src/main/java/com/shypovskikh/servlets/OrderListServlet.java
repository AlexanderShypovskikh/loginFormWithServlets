package com.shypovskikh.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shypovskikh.model.Coffee;
import com.shypovskikh.model.Order;
import com.shypovskikh.model.OrderItem;

/**
 * Servlet implementation class OrderListServlet
 */
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
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
	    OrderItem item = null;
	    Order order = null;
		 double total = 0;
         List<Coffee> orderList = new ArrayList();
         List<Coffee> list = (ArrayList)request.getServletContext().getAttribute("listCoffee");
	     String[] params  = request.getParameterValues("checkbox"); 
	    List<Integer> quantity = new ArrayList();
         String[] paramsQuant = request.getParameterValues("quantity");
       
        System.out.println("coffee is empty = "+list.toString());
         System.out.println("chekbox = "+Arrays.toString(params));
          System.out.print("params quant = "+Arrays.toString(paramsQuant));
	
           int id = 0;
             for(int i = 0; i < params.length; i++ ) {
          	  orderList.add(list.get(Integer.parseInt(params[i]) -1));
          	   id = Integer.parseInt(params[i]);
          	   //System.out.print();
          	  quantity.add(Integer.parseInt(paramsQuant[id-1]));
          	  
          	  total += quantity.get(i)*orderList.get(i).getPrice();
            }
            request.setAttribute("selectedList", orderList);
            request.setAttribute("quantity", quantity);
  	        request.setAttribute("cost", total);
  	    
  	     
     
	     RequestDispatcher rd = request.getRequestDispatcher("jsp/orderList.jsp");
			rd.forward(request, response);
	}

}
