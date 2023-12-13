package com.dollop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DbCon {
	private static final String DB_USER="root";
	private static final String DB_PSW="";
	private static final String DB_URL="jdbc:mysql://localhost:3306/jdbcdemo";
	private static final String DB_Driver="com.mysql.cj.jdbc.Driver";
	private static final String INSERT_STD="INSERT INTO `student`(`StName`, `Score`) VALUES ('ANKIt','88')";
	private static final String UPDATE_STD="UPDATE `student` SET `Score`='56' WHERE StID=1";
	private static final String SELECT_STD="SELECT * FROM `student` WHERE 1";
	private static final String DELETE_STD="DELETE FROM `student` WHERE StID=1";
   public static void main(String[] args)throws Exception { 
	   // load Driver
	    Class.forName(DB_Driver);
	    // set Connection
	  Connection con =  DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
	  //create Statement
	  Statement stmt = con.createStatement();
	 //execute Queuery
	  // int affectedRows=stmt.executeUpdate(INSERT_STD);
	  // System.out.println(affectedRows+"affected Rows");
	     ResultSet  rs=stmt.executeQuery(SELECT_STD);
	     while(rs.next())
	     {
	    	 System.out.print(rs.getInt("StId"));
	    	 System.out.print(rs.getString("StName"));
	    	 System.out.println(rs.getDouble("Score"));
	     }
	     
	     con.close();
	   
	    
  }
}
