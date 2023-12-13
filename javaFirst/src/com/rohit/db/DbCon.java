package com.rohit.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DbCon {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdemo";
	private static final String DB_USER = "root";
	private static final String DB_PSW = "";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String INSERT_BOOK="INSERT INTO `book`(`BKName`, `BKPrice`) VALUES ('C','250')";
    private static final String UPDATE_BOOK = "UPDATE `book` SET `BKName`='D',`BKPrice`='400' WHERE BkID=3"; 
	private static final String SELECT_BOOK ="SELECT * FROM `book` Where 1";
    private static final String DELETE_BOOK = "DELETE FROM `book` WHERE BkID=3";
	public static void main(String[] args)throws Exception {
      // Load Driver
		 Class.forName(DB_DRIVER);
      // get Connection
		 Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PSW);
		//create Statement
		 Statement stmt = con.createStatement() ;
		// Execute Query
		 /*
		  * DDL
		  * DML  INSERT INTO `book`(`BkID`, `BKName`, `BKPrice`) VALUES ('[value-1]','[value-2]','[value-3]')
		  * DRL
		  */
		 
		int affectedRows= stmt.executeUpdate(DELETE_BOOK);
		System.out.println(affectedRows+"ROws deleted");
		 //result set
/*		 ResultSet rs = stmt.executeQuery(SELECT_BOOK);
		 System.out.print(String.format("%5s","S.NO."));
		 System.out.print(String.format("%17s","BOOK NAME"));
		 System.out.println(String.format("%13s","BOOK PRICE"));
		
		 while(rs.next())
		 {
		    System.out.print(String.format("%5d",rs.getInt("BkID")));
		     System.out.print(String.format("%13s",rs.getString("BKName")));
		      System.out.println(String.format("%13s",rs.getDouble("BKPrice")));
		 }
		 */	 
		con.close();
	}
}
