package com.dollop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dollop.DAO.PhoneBookDAO;
import com.dollop.service.PhoneBookDaoImpl;

/**
 * Servlet implementation class FileHandler
 */
public class FileHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PhoneBookDAO ph = new PhoneBookDaoImpl();
		HttpSession session = request.getSession();
            ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
            try {
            	List<FileItem> item= upload.parseRequest(request);
            	for(FileItem fileItem: item) {
                     
                    if( ph.uploadImg((Integer)session.getAttribute("login"),fileItem.getName())) {
            		fileItem.write(new File("C:\\sts-4.17.1.RELEASE\\javaPrograms\\ContactBook\\src\\main\\webapp\\imgtry\\"+fileItem.getName()));
            		request.setAttribute("image",fileItem.getName());
            		session.setAttribute("ProfileImg",fileItem.getName());
            		RequestDispatcher rd = request.getRequestDispatcher("./profile.jsp");
            		rd.forward(request, response);
                    }
                    else {
                    	response.getWriter().append("Served at: failed").append(request.getContextPath());
                    }
            	}
            }catch(Exception e) {e.printStackTrace();}
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
