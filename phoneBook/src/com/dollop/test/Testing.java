package com.dollop.test;

import java.util.List;
import java.util.Scanner;

import com.dollop.DAO.PhoneBookDAO;
import com.dollop.entity.Contacts;
import com.dollop.entity.User;
import com.dollop.lib.Validation;
import com.dollop.service.PhoneBookDAOImpl;

public class Testing {
	Scanner sc=null;
	  PhoneBookDAO ph = new PhoneBookDAOImpl();
	  User us=null;
	  Validation vld = null;;
	Testing()
	{
		sc = new Scanner(System.in);
		vld = new Validation();
	}
	
	public void homePageMenu()
	{
		System.out.println("---------HOME---------");
		System.out.println("1. LOGIN");
		System.out.println("2. REGISTRATION");
		System.out.println("3. EXIT");
		int ch = sc.nextInt();
		switch(ch)
		{
		    case 1:
		    	 login();
		    	 break;

		    case 2:
		    	 registration();
		    	 break;

		    case 3:
		    	 System.exit(ch);
		    	 break;		    			    	
		}
		homePageMenu();
	}

	private void login() {
		if(us==null||!ph.isLogin(us))
		{
		System.out.println("------LOGIN------");
		us = new User();
		System.out.println("ENTRE YOUR NAME");
		sc.nextLine();
		us.setName(sc.nextLine());
		System.out.println("ENTRE YOUR PASSWORD");
		us.setPassword(sc.nextLine());
		if (ph.login(us))
			deshBoard(us);
		else {
		       System.out.println("Wrong Password");
	    	   us=null;
     		}
		}
		else 
			deshBoard(us);
	}

	private void deshBoard(User us) {
		System.out.println("----WELCOME----");
		System.out.println("1. ADD CONTACT");
		System.out.println("2. VIEW CONTACT");
		System.out.println("3. EDIT CONTACT");
		System.out.println("4. SEARCH CONTACT");
		System.out.println("5. logOut");
		System.out.println("6. EXIT");
		int ch=sc.nextInt();
		switch(ch)
		{
		     case 1:
			      addContact();
			      break;

		     case 2:
			      viewContact();
			      break;
             case 3:
			      editContact();
			      break;
       		 case 4:
 		     	  searchContact();
			      break;
		     case 5:
		          ph.logOut(us);
		          us=null;
		          return;		   
		     case 6: 
		    	 System.out.println("NIKAL PEHLI FURSAT ME NIKAL");
		    	 return;
		}	
		deshBoard(us);
	}
	  public void baseContactMenu(){
	    	 System.out.print(String.format("%5s","ID"));
			 System.out.print(String.format("%17s","NAME"));
			 System.out.print(String.format("%20s","EMAIL"));
			 System.out.print(String.format("%21s","MOBILE NO"));
			 System.out.print(String.format("%21s","ADDRESS"));
			 System.out.println(String.format("%21s","CREATED DATE"));			 
	    }
	
	private void searchContact() {
		System.out.println("1. SEARCH BY NAME");
		System.out.println("2. SEARCH BY MOBILE NO");
		  Contacts con =null;
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice)
		{
		case 1:
			  System.out.println("ENTRE NAME");
			  String name = sc.nextLine();
			   con = ph.getContact(name);
			  break;
		case 2: 
			  System.out.println("ENTRE MOBILE NO");
			  String no = sc.nextLine();
			  break;
		}
		baseContactMenu();
		if(con!=null) {
		  System.out.print(String.format("%3d",con.getId()));
		   System.out.print(String.format("%13s",con.getName()));
		   System.out.print(String.format("%29s",con.getEmail()));
		   System.out.print(String.format("%15s",con.getMobile()));
		   System.out.print(String.format("%22s",con.getAddress()));
		   System.out.println(String.format("%22s",con.getDate()));
		}	
		
	}

	private void editContact() {
		System.out.println("ENTRE CONTACT ID");
		int id=sc.nextInt();
	      Contacts c =ph.getContact(id);
	      
		System.out.println("1.CHANGE NAME");
		System.out.println("2. CHANGE EMAIL");
		System.out.println("3. CHANGE MOBILENO");
		System.out.println("4. CHANGE ADDRESS");
		System.out.println("5. BACK");
		int ch=sc.nextInt();
		sc.nextLine();
		switch(ch)
		{
		     case 1:
			       System.out.println("ENTRE NAME");
			       c.setName(sc.nextLine());
			       break;

		     case 2:
			       System.out.println("ENTRE EMAIL");
			       c.setEmail(sc.nextLine());
			       break;

		     case 3:
			       System.out.println("ENTRE MOBILE NO");
			       c.setMobile(sc.nextLine());
			       break;

		     case 4:
			       System.out.println("ENTRE ADDRESS");
			       c.setAddress(sc.nextLine());
			       break;

		     case 5:
		    	 System.out.println("AYA KYU THA FIR CHU..........!!!!");
		}
		if(ph.updateContact(c))
			System.out.println("UPDATED SUCCESSFULLY");
		else
			System.out.println("FAILED...........:(");	
	}

	private void viewContact() {
		baseContactMenu();
		List<Contacts> al = ph.getContacts(ph.getUser(us.getName()));
		for (int i = 0; i < al.size(); i++) 
		{
			Contacts con = al.get(i);
			System.out.print(String.format("%5d", con.getId()));
			System.out.print(String.format("%16s", con.getName()));
			System.out.print(String.format("%23s", con.getEmail()));
			System.out.print(String.format("%19s", con.getMobile()));
			System.out.print(String.format("%22s", con.getAddress()));
			System.out.println(String.format("%20s", con.getDate()));
		}	
	}

	private void addContact() {
		Contacts cont = new Contacts();
		System.out.println("ENTRE NAME");
		sc.nextLine();
		cont.setName(sc.nextLine());
		System.out.println("ENTRE MOBILE NO.");
		cont.setMobile(sc.nextLine());
		System.out.println("ENTRE ADDRESS");
		cont.setAddress(sc.nextLine());
		System.out.println("ENTRE YOUR EMAIL");
		cont.setEmail(sc.nextLine());
		cont.setUserId(ph.getUser(us.getName()));
		if (ph.addContact(cont))
			System.out.println("SUCCESSFULLY ADDED");
		else
			System.out.println("SUCCESSFULLY FAILED");
	}

	private void registration() {
	       us = new User();
	      boolean flag=true;
	      String ps=null;
	  	System.out.println("ENTRE YOUR NAME");
		sc.nextLine();
		us.setName(sc.nextLine());
		System.out.println("ENTRE YOUR CONTACT NO.");
		us.setContact(sc.nextLine());
		System.out.println("ENTRE YOUR ADDRESS");
		us.setAddress(sc.nextLine());
		System.out.println("ENTRE YOUR EMAIL");
		us.setEmail(sc.nextLine());
		while(flag)
		{
			System.out.println("ENTRE YOUR PASSWORD");
			 ps = sc.nextLine();
			System.out.println("CONFIRM PASSWORD");
			String cn = sc.nextLine();
	       if ( vld.isPassword(ps,cn))
				break;
			else {
				System.out.println("PASSWORD MUST HAVE 8 CHARACTERS"+"\n"+"PASSWORD DOESN'T MATCH"+"\n"+"PRESS Y TO RE-ENTRE "+"\n"+" PRESS N TO EXIT");
				String ch = sc.nextLine();
				if(ch.contains("n")||ch.contains("N"))
				{
				 flag=false;
					break;
				}
			}
		}
		if(verify(us))
		{
			if (flag == true) {
				us.setPassword(ps);
				System.out.println(ph.registration(us)); // TODO Auto-generated method stub
				System.out.println("ADDED SUCCESSFULLY");
			}
		}
		else
		{
			System.out.println("PRESS Y TO RE-ENTRE "+"\n"+" PRESS N TO EXIT");
			String ch = sc.nextLine();
			if(ch.contains("Y")||ch.contains("y"))
			{
				registration();
			}
		}
		us=null;
	}

	//-----VERIFY DETAILS FORMAT----\\
	
	private boolean verify(User us2) {
		if(vld.isName(us2.getName()))
		{
			  if(vld.isEmail(us2.getEmail()))
			  {
				  if(vld.isMobile(us2.getContact()))
				  {	  
				  }
				  else
				  {
					  System.out.println("INCORRECT MOBILE NO");
					   return false;
				  }
			  }
			  else
			  {
				  System.out.println("INCORRECT EMAIL ID");
				   return false;
			  }
		}
	   else
		  {
			  System.out.println("INCORRECT NAME FORMAT");
			   return false;
		  }
		return true;
	}

	public static void main(String[] args) {
		Testing t = new Testing();
		t.homePageMenu();
	}
}
