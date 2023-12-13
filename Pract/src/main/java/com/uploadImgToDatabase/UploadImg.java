package com.uploadImgToDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class UploadImg {
	private static final String UPLOAD_IMG ="insert into images (img_name,image) values(?,?)";
Connection con;
	
	public boolean UploadImg(String filename) {
		try {
			File f = new File(filename);
			FileInputStream fi = new FileInputStream(f);
		   con = DbConnection.getConnection();
		   PreparedStatement pstmt= con.prepareStatement(UPLOAD_IMG);
		   pstmt.setString(1,"image");
		   pstmt.setBinaryStream(2, fi, (int) f.length());
		   
        		    return pstmt.executeUpdate()>0;
		} catch (Exception e) {e.printStackTrace();}
		
		
		return false;
	}
}




 class DbConnection {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
  private static final String DB_USER="root";
  private static final String DB_PSW="";
  private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
  
	private static Connection con = null;

	public static Connection getConnection() {
		if (con != null)
			return con;
		return getConnection(DB_URL, DB_USER, DB_PSW);
	}

	private static Connection getConnection(String dbUrl, String dbUser, String dbPsw) {
		try {
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPsw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
  
	
	
	
}