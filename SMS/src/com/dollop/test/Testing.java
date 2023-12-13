package com.dollop.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dollop.dao.StudentDAO;
import com.dollop.db.DbConnection;
import com.dollop.entity.Student;
import com.dollop.services.StudentDAOImpl;

public class Testing {
	
	Scanner sc = null;
	StudentDAO student = new StudentDAOImpl();
	
	Testing(){
		sc= new Scanner(System.in);
	}
	
	public void homePageMenu() throws Exception
	{
		System.out.println("---------HOME---------");
		System.out.println("1. ADD STUDENT");
		System.out.println("2. SHOW ALL STUDENT LISTS");
		System.out.println("3. SHOW STUDENT BY ID");
		System.out.println("4. UPDATE STU2DENT INFO");
		System.out.println("5. DELETE STUDENT BY ID");
		System.out.println("6. EXIT");
		int id ;
		int choice = sc.nextInt();
		switch(choice)
		{
		     case 1:
		    	 addStudent();
		    	 break;
		     case 2:
		    	 showStudentList();
		    	 break;
		    	 
		     case 3:
		    	 System.out.println("ENTRE STUDENT ID");
		    	  id = sc.nextInt();
		    	 showStudentList(id);
		    	 break;
		     case 4:
		    	 System.out.println("ENTRE STUDENT ID");
		    	  id = sc.nextInt();
		    	 updateStudent(id);
		    	 break;
		     case 5:
		    	 System.out.println("ENTRE STUDENT ID");
		    	  id = sc.nextInt();
		    	 deleteStudent(id);
		    	 break;
		     case 6:
		    	 System.exit(choice);
		}
		homePageMenu();
	}
	
    public void baseMenu()
    {
    	 System.out.print(String.format("%5s","S.ID"));
		 System.out.print(String.format("%17s","STUDENT NAME"));
		 System.out.print(String.format("%20s","STUDENT EMAIL"));
		 System.out.print(String.format("%21s","STUDENT PASSWORD"));
		 System.out.print(String.format("%21s","STUDENT CONTACT"));
		 System.out.println(String.format("%21s","STUDENT ADDRESS"));
		 
    }
	
	private void deleteStudent(int id) throws SQLException, Exception {
		student.delete(id);
		System.out.println("DELETED SUCCESSFULL");
		
	}

	private void updateStudent(int id) throws SQLException, Exception {
	    Student st = student.get(id);
	    st.setsName("Sahil");
	    st.setsEmail("sahilKhan@123@gmail.123.com");
	    st.setsPassWord("6263705434");
	    st.setsContact("12345678");
	    st.setsAddress("INDORE MP");
	    boolean affected = student.update(st);
	    if(affected==false)
	    	 System.out.println("UPDATE FAILURE");
	    else {
	    	System.out.println("UPDATE SUCCESSFUL");
	    }
		  
	}

	private void showStudentList() throws Exception {
		baseMenu();
	   List<Student> studentList=student.get();
	   for(int i=0;i<studentList.size();i++)
	   {
		   Student st=studentList.get(i);
		   System.out.print(String.format("%3d",st.getsId()));
		   System.out.print(String.format("%13s",st.getsName()));
		   System.out.print(String.format("%29s",st.getsEmail()));
		   System.out.print(String.format("%15s",st.getsPassWord()));
		   System.out.print(String.format("%21s",st.getsContact()));
		   System.out.println(String.format("%22s",st.getsAddress()));
	   }
	}

	private void showStudentList(int id) throws SQLException, Exception
	{
		baseMenu();
		   Student st=student.get(id);
		   if(st!=null)
		   {
			   System.out.print(String.format("%3d",st.getsId()));
			   System.out.print(String.format("%13s",st.getsName()));
			   System.out.print(String.format("%29s",st.getsEmail()));
			   System.out.print(String.format("%15s",st.getsPassWord()));
			   System.out.print(String.format("%21s",st.getsContact()));
			   System.out.println(String.format("%22s",st.getsAddress()));
		   }
	}
	
	private void addStudent() throws Exception {
		Student std= new Student();
		System.out.println("ENTRE STUDENT NAME");
		sc.nextLine();
		std.setsName(sc.nextLine());
		System.out.println("ENTRE STUDENT EMAIL");
		std.setsEmail(sc.nextLine());
		System.out.println("ENTRE STUDENT PASSWORD");
		std.setsPassWord(sc.nextLine());
		System.out.println("ENTRE STUDENT CONTACT NO.");
		std.setsContact(sc.nextLine());
		System.out.println("ENTRE STUDENT ADDRESS");
		std.setsAddress(sc.nextLine());
		student.save(std);
		System.out.println("ADDED SUCCESSFULLY");
	}

	public static void main(String[] args) throws Exception {
      
	Student student = new Student();
	Student student1 = new Student();
	student1.setsName("Rohit");
	student1.setsEmail("rohitlodhi107@gmail.com");
	student1.setsPassWord("12345678");
	student1.setsContact("6263703637");
	student1.setsAddress("VIDISHA MP");
	 StudentDAO st = new StudentDAOImpl();
	 //student = st.get(3);
	 //List<Student> studentLists=st.get();
	// for(Student std:studentLists)
	//	 System.out.println(st.updateStudentContact("9522215342", 2));
	 Testing t = new Testing();
	 t.homePageMenu();
		 
	// System.out.println(st.save(student1));
	 //System.out.println(st.update(student1));
	}

}
