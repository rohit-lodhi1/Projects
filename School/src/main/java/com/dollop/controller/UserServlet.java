package com.dollop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dollop.DAO.SchoolDAO;
import com.dollop.entity.User;

import com.dollop.service.SchoolDaoImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action =request.getParameter("action"); 
			switch(action)
			{
			    case "createAccount":
				      createAccount(request, response);
				      break;
			    case "login":
				      login(request, response);
				      break;
			    case "logout":
			    	  logout(request, response);
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("./login.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		SchoolDAO ph = new SchoolDaoImpl();
		HttpSession session = request.getSession();
		int id = ph.login(email,password,type);
		RequestDispatcher rd = request.getRequestDispatcher("./login.jsp");
		if(id>0)
		{
			    session.setAttribute("login",id);
			    session.setAttribute("type",type);
				request.setAttribute("msg","Login Success");
				if(type.equals("ADMIN"))
				   rd=request.getRequestDispatcher("./adminDashboard.jsp");
				
				if(type.equals("TEACHER"))
					rd=request.getRequestDispatcher("./TeacherDashboard.jsp");
				
				if(type.equals("STUDENT"))
					rd=request.getRequestDispatcher("./studentDashboard.jsp");
				rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg","Login Failed...!!!");
			rd.forward(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());	
	}

	private void createAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User us = new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("MobileNo"),
				request.getParameter("password"),request.getParameter("type"));
		System.out.println(request.getParameter("type"));
		SchoolDAO ph = new SchoolDaoImpl();
		if (us.getPassword().equals(request.getParameter("cpassword"))) {
			if (ph.registration(us)) {
				response.getWriter().append("REGISTRATION SUCCESSFULL");
				response.sendRedirect("./index.jsp");
			} else {
				response.getWriter().append("REGISTRATION FAILED");
			}
		} else
			response.getWriter().append("REGISTRATION FAILED PASSWORD DOESN'T MATCH");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
