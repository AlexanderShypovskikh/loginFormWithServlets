package com.shypovskikh.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.shypovskikh.DAO.DAO;
import com.shypovskikh.DAOImpl.PostgreSQLDAOImpl;
import com.shypovskikh.model.User;

/**
 * Servlet Filter implementation class CheckLoginForm
 */
public class CheckLoginForm implements Filter {
	private DataSource dataSource = null;

    /**
     * Default constructor. 
     */
    public CheckLoginForm() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init CheckLoginForm filter");
		
		try {
			//Class.forName("org.postgresql.Driver");
			Context initContext = new InitialContext();
		    Context envContext = (Context) initContext.lookup("java:/comp/env");
		     dataSource = (DataSource)envContext.lookup("jdbc/postgresql");
		     System.out.println("dataSource = "+dataSource);
		     fConfig.getServletContext().setAttribute("dataSource", dataSource);
		     System.out.println("dataSource = "+fConfig.getServletContext().getAttribute("dataSource"));
		    System.out.print("using JNDI lookup get the datasource: "+dataSource);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	
    
   
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 String login = request.getParameter("login");
		 String pass = request.getParameter("password"); 
		 System.out.println("Check Filter login :"+login+" pass:"+pass);
		 
		  DAO data = null;
		  Connection conn = null;
	      RequestDispatcher rd = null;
          conn = getConnection();
		  
                 if(conn != null) {
		    	    	data = new PostgreSQLDAOImpl(conn);
		            	User user = (User)data.getUser(login, pass);
		            	System.out.println("Check Filter user = "+user);
		            if(user != null) {
		            	System.out.println(user.toString());
		                System.out.println("Check Filter user role "+user.getRole());
		                //request.setAttribute("user", user);
		                request.getServletContext().setAttribute("user", user);
		              //  	if (user.getRole().equals("admin")) {
		               // 		request.setAttribute("user", user);
		               // 		rd = request.getRequestDispatcher("jsp/coffeeList.jsp");
		               // 		rd.forward(request, response);
		               // 		} else {
		                				chain.doFilter(request, response);
		                //				}
		            	} else {
		            		rd = request.getRequestDispatcher("index.jsp");
		            		rd.forward(request, response);
		   	 		  		}
		            }
       
	}

	
	
	   public Connection getConnection() {
		   try {
			   
		    return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Нельзя создать подключение");
			e.printStackTrace();
		} 
		   return null;
	   }
	 /**
		 * @see Filter#destroy()
		 */
		public void destroy() {
			// TODO Auto-generated method stub
		}


}
