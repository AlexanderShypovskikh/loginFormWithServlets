package com.shypovskikh.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CheckLoginForm
 */
public class CheckLoginForm implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLoginForm() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("login="+request.getParameter("login"));
		System.out.println("pass="+request.getParameter("pass"));
		
		 if((request.getParameter("login") == "") || (request.getParameter("pass") == "")) {
			 System.out.println("Fill data correctly");
			 HttpServletResponse resp =  (HttpServletResponse)response;
			 resp.sendRedirect("index.jsp");
		     } else
		  		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init CheckLoginForm filter");
	}

}
