package com.dollop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.DAO.PhoneBookDAO;
import com.dollop.entity.Contacts;
import com.dollop.service.PhoneBookDaoImpl;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getParameter("action")) {
		case "addContact":
			        addContact(request, response);
			        break;
		case "editContact":
			        editContact(request, response);
			        break;
		case "viewContact":
			         viewContact(request, response);
			         break;
		case "delete":
			         deleteContact(request, response);
			         break;
		case "saveContact":
			         saveContact(request, response);
			         break;
		case "search":
			         searchContact(request, response);
			         break;
		case "multi":
			        multipleDelete(request,response);
			        break;
		case "sorty":
			       sorty(request,response);
			       break;
		}
		response.getWriter().append("failure").append(request.getContextPath());
	}

	private void sorty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String q=" ORDER BY Name ASC";
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		if(Integer.parseInt(request.getParameter("id"))==2)
			q=" ORDER BY Name DESC";
		
      		List<Contacts> list = ph.getContacts((int)session.getAttribute("login"),q);

					request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("./viewContact.jsp");
			rd.forward(request, response);
		
	}

	private void multipleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String a[]=request.getParameterValues("check");
	   PhoneBookDAO ph = new PhoneBookDaoImpl();
	 for(int i=0;i<a.length-1;i++)
	 {
		 ph.deleteContact(Integer.parseInt(a[i]));
	 }
	 if(ph.deleteContact(Integer.parseInt(a[a.length-1]))) {
		 viewContact(request, response);
				 
	}
	 else {
			response.getWriter().append("failed");
	 }
	}

	private void searchContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		HttpSession session = request.getSession();
		List<Contacts> list = ph.getContact(name,(Integer)session.getAttribute("login"));
		if (list != null) 
			request.setAttribute("list_search", list);			
		if(request.getParameter("name").length()==0)
			viewContact(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("./viewContact.jsp");
		rd.forward(request, response);
	}

	private void saveContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Contacts con = new Contacts(request.getParameter("name"), request.getParameter("email"),
				request.getParameter("MobileNo"), request.getParameter("Address"));
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		con.setId(Integer.parseInt(request.getParameter("id")));
		if (ph.addContact(con)) 
		{
			viewContact(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("./viewContact.jsp");
			rd.forward(request, response);
		} else
			response.getWriter().append("failed");
	}

	private void deleteContact(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		int id = Integer.parseInt((request.getParameter("id")));
		if (ph.deleteContact(id)) 
		{
			viewContact(request,response);
			RequestDispatcher rd = request.getRequestDispatcher("./viewContact.jsp");
			rd.forward(request, response);
		} else
			response.getWriter().append("FAILED");
	}

	private void viewContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		List<Contacts> list = ph.getContacts((int)session.getAttribute("login"));
		if (list != null) {
			request.setAttribute("list", list);
			
		} else
			response.getWriter().append("FAILED");
		RequestDispatcher rd = request.getRequestDispatcher("./viewContact.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void editContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		Contacts conup = ph.getContact(Integer.parseInt(request.getParameter("id")));
		HttpSession session = request.getSession();
		conup.setUserId((Integer) session.getAttribute("login"));
		if (conup != null) {
			request.setAttribute("Contact", conup);
			request.setAttribute("on", true);
			viewContact(request,response);
			RequestDispatcher rd = request.getRequestDispatcher("./viewContact.jsp");
			rd.forward(request, response);
		} else
			addContact(request, response);
	}

	private void addContact(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Contacts con = new Contacts(request.getParameter("name"), request.getParameter("email"),
				request.getParameter("MobileNo"), request.getParameter("Address"));
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		HttpSession session = request.getSession();
		con.setUserId((Integer) session.getAttribute("login"));
		if (ph.addContact(con)) {
			response.getWriter().append("ADDED SUCCESSFULLY");
			viewContact(request,response);
			RequestDispatcher rd = request.getRequestDispatcher("./viewContact.jsp");
			rd.forward(request, response);
			
		} else
			response.getWriter().append("FAILED");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
