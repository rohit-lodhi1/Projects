package com.roverse.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.roverse.DAO.RoverseDAO;
import com.roverse.db.DbConnection;
import com.roverse.entity.User;

public class RoverseDAOImpl implements RoverseDAO {
	
	Connection con = null;
	PreparedStatement pstmt = null;

//	<--- Query-of-MySql  --->
	private static final String INSER_USER ="INSERT INTO `user`(`Name`, `Email`, `Password`,`ProfileImg`, `Address`) VALUES (?,?,?,?,?)";
	
	
	
	
	public User login(String email, String password) {

		return null;
	}

	public Boolean registration(User us) {
		con=DbConnection.getConnection();
		 try {
			pstmt = con.prepareStatement(INSER_USER);
			pstmt.setString(1,us.getName());
			pstmt.setString(2,us.getEmail());
			pstmt.setString(3,us.getPassword());
			pstmt.setString(4,us.getProfileImg());
			pstmt.setString(5,us.getAddress());
			int affected = pstmt.executeUpdate();
			   return affected>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return false;	
	}

}
