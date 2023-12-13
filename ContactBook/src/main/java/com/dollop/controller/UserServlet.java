package com.dollop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dollop.DAO.PhoneBookDAO;
import com.dollop.entity.Contacts;
import com.dollop.entity.User;
import com.dollop.service.PhoneBookDaoImpl;

@MultipartConfig
/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private final String Upload_Directory="C:/uplprofile";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
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
		    	  break;
		    case "editUser":
		    	   editUser(request,response);
		    	   break;
		    case "saveUser":
		    	   saveUser(request,response);
		    	   break;
		    case "updateProfile":
		    	   updateProfile(request,response);
		    	   break;
		}
		response.getWriter().append("Served: failed").append(request.getContextPath());
	}

	private void updateProfile(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException, ServletException {
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		HttpSession session = request.getSession();
            ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
            try {
            	List<FileItem> item= upload.parseRequest(request);
            	System.out.println(item);
            	for(FileItem fileItem: item) {
            		System.out.println(fileItem.getName());
                     
                    if( ph.uploadImg((Integer)session.getAttribute("login"),fileItem.getName())) {
            		fileItem.write(new File("C:\\sts-4.17.1.RELEASE\\javaPrograms\\ContactBook\\src\\main\\webapp\\imgtry\\"+fileItem.getName()));
            		request.setAttribute("image",fileItem.getName());
            		RequestDispatcher rd = request.getRequestDispatcher("./profile.jsp");
            		rd.forward(request, response);
                    }
                    else {
                    	response.getWriter().append("Served at: failed").append(request.getContextPath());
                    }
            	}
            }catch(Exception e) {e.printStackTrace();}
	}

	private void saveUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		User us = new User(request.getParameter("name"),request.getParameter("email"),request.getParameter("MobileNo"),request.getParameter("password"));
		HttpSession session = request.getSession();
		us.setId(Integer.parseInt(request.getParameter("id")));
		if(ph.registration(us))
		{
			RequestDispatcher rd = request.getRequestDispatcher("./profile.jsp");
			rd.forward(request, response);
		}
		
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		
		HttpSession session = request.getSession();
		User us = ph.getUser((Integer)session.getAttribute("login"));
		if (us != null) {
			request.setAttribute("User", us);
			request.setAttribute("on", true);
			RequestDispatcher rd = request.getRequestDispatcher("./profile.jsp");
			rd.forward(request, response);
		} else {
			response.getWriter().append("Served at: ");
		}
		
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
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		HttpSession session = request.getSession();
		User us = ph.login(email,password);
		System.out.println(us);
		if(us!=null)
		{
			System.out.println("inside controle");
			    session.setAttribute("login",us.getId());
          //       System.out.println(us.getImage());
				session.setAttribute("ProfileImg",us.getImage());
				RequestDispatcher rd=request.getRequestDispatcher("./dashboard.jsp");
				rd.forward(request, response);
		}
		else
		{
			request.setAttribute("msg","Login Failed...!!!");
			RequestDispatcher rd=request.getRequestDispatcher("./login.jsp");
			rd.forward(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());	
	}

	private void createAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User us = new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("MobileNo"),
				request.getParameter("password"));
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		if (us.getPassword().equals(request.getParameter("cpassword"))) {
			if (ph.registration(us)) {
				response.getWriter().append("REGISTRATION SUCCESSFULL");
			} else {
				response.getWriter().append("REGISTRATION FAILED");
			}
		} else
			response.getWriter().append("REGISTRATION FAILED PASSWORD DOESN'T MATCH");
		response.sendRedirect("./signup.jsp");
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


