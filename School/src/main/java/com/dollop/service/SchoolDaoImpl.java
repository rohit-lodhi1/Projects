package com.dollop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.spi.ServiceRegistry.Filter;

import com.dollop.DAO.SchoolDAO;
import com.dollop.Db.DbConnection;
import com.dollop.entity.User;

public class SchoolDaoImpl implements SchoolDAO {

	private static final String INSERT_USER = "INSERT INTO `user`(`Name`, `Email`, `Password`, `MobileNo`, `Type`) VALUES (?,?,?,?,?)" ;
	private static final String UPDATE_USER ="UPDATE `student_rec` SET `sName`=?,`sEmail`=?,`sPassword`=?,`sContact`=?,`sAddress`=? WHERE sID=?";
	private static final String SELECT_USER = "SELECT `ID`, `Name`, `Email`, `Password` FROM `user` WHERE Email=? AND Password=? AND Type=?";
	private static final String SELECT_USER_BY_UNAME ="SELECT `ID`, `uName`, `uEmail`, `uPassword`, `uContact`, `uAddress`, `uStatus` FROM `user` WHERE uName=?";
	private static final String DELETE_USER ="DELETE FROM `student_rec` WHERE sID=?" ;
	private static final String UPDATE_USER_STATUS ="UPDATE `user` SET `uStatus`=? WHERE ID=?";
	private static final String INSERT_CONTACT = "INSERT INTO `contacts`(`Name`, `Email`, `MobileNo`, `Address`, `UID`) VALUES (?,?,?,?,?)";
	private static final String SELECT_CONTACT_BY_UID ="SELECT `ID`, `Name`, `Email`, `MobileNo`, `Address`,`CreateDate` FROM `contacts` WHERE uID=?";
	private static final String SELECT_CONTACT_BY_ID ="SELECT `ID`, `Name`, `Email`, `MobileNo`, `Address`, `uID`, `CreateDate` FROM `contacts` WHERE ID=?";
	private static final String UPDATE_CONTACT_BY_ID ="UPDATE `contacts` SET `Name`=?,`Email`=?,`MobileNo`=?,`Address`=? WHERE ID=?";
	private static final String SELECT_CONTACT_BY_NAME ="SELECT `ID`, `Name`, `Email`, `MobileNo`, `Address`,`CreateDate` FROM `contacts` WHERE Name=? AND UID=?";
	private static final String DELETE_CONTACT_BY_ID="DELETE FROM `contacts` WHERE ID=?";
	PreparedStatement pstmt = null;
	Connection con=null;
	
	public int login(String email,String password,String type) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, type);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt("ID");
			
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("not found");
		}
		return 0;
	}

	
	public boolean registration(User u) {
		
		int affected=0;
		   try{
			   con = DbConnection.getConnection();
			 pstmt = con.prepareStatement(INSERT_USER);
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   try {
			pstmt.setString(1,u.getName());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3,u.getPassword());
			pstmt.setString(4,u.getMobile());
			pstmt.setString(5,u.getType());
			affected =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return affected>0?true:false;
			
	}
	
	
	public boolean logOut(User u)
	{
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER_BY_UNAME);
			 pstmt.setString(1,u.getName());
			 ResultSet rs = pstmt.executeQuery();
			rs.next();
				  if(rs.getString("uPassword").equals(u.getPassword()))
				  {
					  pstmt = con.prepareStatement(UPDATE_USER_STATUS);
					  pstmt.setInt(1,0);
					  pstmt.setInt(2,rs.getInt("ID"));
					  pstmt.executeUpdate();
					  return true;
		         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return false;
	}

	public boolean isLogin(User us) {
		// TODO Auto-generated method stub
		return false;
	}
}
