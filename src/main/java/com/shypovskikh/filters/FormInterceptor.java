package com.shypovskikh.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FormInterceptor
 */
public class FormInterceptor implements Filter {

    /**
     * Default constructor. 
     */
    public FormInterceptor() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		 System.out.println("destroy filter");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response; 
        System.out.println("login="+req.getAttribute("login"));
        System.out.println("pass="+req.getAttribute("pass"));
        String login = (String) req.getAttribute("login");
        String pass = (String) req.getAttribute("pass");
        
        if((login == null) || ((String) req.getAttribute("pass") == null))
        	resp.sendRedirect("index.jsp");
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	   System.out.println("init filter");
	}

}
