package com.dollop.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dollop.DAO.UserDao;
import com.dollop.DbConnection.DbConnection;
import com.dollop.entity.User;

public class UserDaoImpl implements UserDao {
	private static final String INSERT_USER = "INSERT INTO `user`(`Name`, `Email`, `Password`) VALUES (?,?,?)" ;
	private static final String SELECT_USER ="SELECT `ID`, `Name`, `Email`, `Password` FROM `user` WHERE Email=? AND Password=?"; 
	PreparedStatement pstmt = null;
	Connection con=null;
	
	public boolean save(User us) {
		int affected=0;
		   try{
			   con = DbConnection.getConnection();
			 pstmt = con.prepareStatement(INSERT_USER);
			 pstmt.setString(1,us.getName());
			 pstmt.setString(2,us.getEmail());
			 pstmt.setString(3,us.getPassword());
			 affected = pstmt.executeUpdate();
			 return affected>0?true:false;
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		return false;
	}

	public boolean login(String email,String password) {
		ResultSet rs=null;
	try{
		con = DbConnection.getConnection();
			 pstmt = con.prepareStatement(SELECT_USER);
			 pstmt.setString(1,email);
			 pstmt.setString(2, password);
			 rs=pstmt.executeQuery();
			 if(rs.next())
			 {
				 return true;
			 }
	}catch(Exception e) {
		e.printStackTrace();
	}
	
		return false;
	}

}
