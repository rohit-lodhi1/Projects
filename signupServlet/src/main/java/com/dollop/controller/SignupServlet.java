package com.dollop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollop.DAO.UserDao;
import com.dollop.DAO.Impl.UserDaoImpl;
import com.dollop.entity.User;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignupServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User us = new User(request.getParameter("name"),request.getParameter("email"),request.getParameter("password"));
		UserDao udao = new UserDaoImpl();
		if(us.getPassword().equals(request.getParameter("cpassword")))
		{
			if(udao.save(us))
			{
				request.setAttribute("msg","REGISTRATION SUCCESSFULL");
				RequestDispatcher rd=request.getRequestDispatcher("./dashboard.jsp");
				rd.forward(request, response);
			}
			else
				response.getWriter().append("Registration FAILED").append(request.getContextPath());
		}
		else
			response.getWriter().append("PASSWORD DOESN'T MATCH").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
