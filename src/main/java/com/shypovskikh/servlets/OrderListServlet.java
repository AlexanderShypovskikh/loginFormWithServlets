package com.shypovskikh.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//String[] checks = request.getParameterValues("check");
	//	String[] quantity = request.getParameterValues("quantity");
	     Map paramsMap = request.getParameterMap();
	     Enumeration enumeration =  request.getParameterNames(); 
	     Iterator iterator = paramsMap.entrySet().iterator();
	     Map<String, String> checkMap = new HashMap();
	     Map<String, String> quantMap = new HashMap();
	     Map<String,Double> priceMap = new HashMap();
	     String name;
	     String[] value;
	     while(iterator.hasNext()) {
	    	 Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>)iterator.next();
	    	 name = entry.getKey();
	    	 value = entry.getValue();
	    	 if(name.startsWith("checkbox")) {
	    		 System.out.println("name = "+name);
	    		 for(int i =0; i < value.length;i++)
	    		 System.out.println("value = "+value[i]);
	    		 checkMap.put(name, value[0]);
	    		 request.setAttribute(name, value);
	    		 String ends = name.replace("checkbox", "");
	    		 System.out.println("ends = "+ends);
	    		 String quant ="quantity".concat(ends);
	    		 System.out.println("quantity = "+quant);
	    	  	  String[] numbers = (String[]) paramsMap.get(quant);
	    	  	  request.setAttribute(quant, numbers[0]);
	    		 String price = "price".concat(ends);
	    		 String[] prices = (String[]) paramsMap.get(price);
	    	  	 double q = Double.parseDouble(numbers[0]);
	    	  	 double p = Double.parseDouble(prices[0]);
	    	  	 
	    	  	 System.out.println("quantity = "+numbers[0]);
	    		 quantMap.put(value[0], numbers[0]);
	    		 priceMap.put(value[0], p*q);
	    		 
	    		 
	    	 }
	     }
	     
	     System.out.println("coffee:"+checkMap.toString());
	     System.out.println("quantMap:"+quantMap.toString());
	     System.out.println("priceMap:"+priceMap.toString());
	     request.getServletContext().setAttribute("coffeeMap", checkMap);
	     request.getServletContext().setAttribute("quantityMap", quantMap);
	     request.getServletContext().setAttribute("priceMap", priceMap);
		 
	     RequestDispatcher rd = request.getRequestDispatcher("jsp/orderList.jsp");
			rd.forward(request, response);
	}

}
