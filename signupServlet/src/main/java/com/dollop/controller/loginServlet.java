package com.dollop.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.DAO.UserDao;
import com.dollop.DAO.Impl.UserDaoImpl;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	 String email=request.getParameter("email");
//	 String password=request.getParameter("password");
//		UserDao udao = new UserDaoImpl();
//		HttpSession session=request.getSession();
//		
//	 if(udao.login(email, password))
//	 {
//		 session.setAttribute("login",true);
//			request.setAttribute("msg","Login Success");
//			RequestDispatcher rd=request.getRequestDispatcher("./dashboard.jsp");
//			rd.forward(request, response);
//	 }
//	 else
//		 response.getWriter().append(" LOGIN failed");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		  StringBuilder buffer = new StringBuilder();
		    BufferedReader reader = request.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        buffer.append(line);
		        buffer.append(System.lineSeparator());
		    }
		    String data = buffer.toString();
		    System.out.println(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
