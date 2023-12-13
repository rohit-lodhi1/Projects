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

public class TeacherAuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  HttpServletRequest httprequest = (HttpServletRequest)request;
	       HttpServletResponse httpresponse = (HttpServletResponse)response;
	       HttpSession session = httprequest.getSession();
	       if(session.getAttribute("login")!=null)
	       {
	    	   if(session.getAttribute("type").equals("TEACHER"))
	    		   chain.doFilter(httprequest, httpresponse);
	    	   else
	           {
	        	   System.out.println("please login");
	        	   httpresponse.sendRedirect("./login.jsp");
	           }
	       }
	       else
	       {
	    	   System.out.println("please login");
	    	   httpresponse.sendRedirect("./login.jsp");
	       }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
