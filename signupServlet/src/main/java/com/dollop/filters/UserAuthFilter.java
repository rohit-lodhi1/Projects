package com.dollop.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
       HttpServletRequest httprequest = (HttpServletRequest)request;
       HttpServletResponse httpreponse = (HttpServletResponse)response;
       HttpSession session = httprequest.getSession();
       if(session.getAttribute("login")!=null)
       {
    	 chain.doFilter(httprequest, httpreponse);
       }
       else
       {
    	   System.out.println("please login");
    	   httpreponse.sendRedirect("./login.jsp");
       }
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
