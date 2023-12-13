package com.dollop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dollop.DAO.PhoneBookDAO;
import com.dollop.db.DbConnection;
import com.dollop.entity.Contacts;
import com.dollop.entity.Groups;
import com.dollop.entity.User;

public class PhoneBookDAOImpl implements PhoneBookDAO {
	private static final String INSERT_USER = "INSERT INTO `user`(`u_name`, `u_email`, `u_password`) VALUES (?,?,?)" ;
	private static final String UPDATE_USER_BY_ID ="UPDATE `user` SET `Name`=?,`Email`=?,`Password`=?,`Contact`=? WHERE ID=?";
	private static final String SELECT_USER_BY_ID = "SELECT `ID`, `Name`, `Email`, `Password`, `Contact` FROM `user` WHERE ID=?";
	private static final String UPDATE_USER ="UPDATE `user` SET `u_name`=?,`u_email`=?,`u_password`=? WHERE u_id=?";
	private static final String SELECT_USER = "SELECT `ID`, `Name`, `Email`, `Password`,`ProfileImg` FROM `user` WHERE Email=? AND Password=?";
	private static final String SELECT_USER_BY_UNAME ="SELECT `ID`, `uName`, `uEmail`, `uPassword`, `uContact`, `uAddress`, `uStatus` FROM `user` WHERE uName=?";
	private static final String DELETE_USER ="DELETE FROM `student_rec` WHERE sID=?" ;
	private static final String UPDATE_USER_STATUS ="UPDATE `user` SET `uStatus`=? WHERE ID=?";
	private static final String INSERT_CONTACT = "INSERT INTO `contacts`(`c_name`, `c_email`, `c_mobile`, `c_groupId`, `c_isfavourite`,`u_id`) VALUES (?,?,?,?,?,?)";
	private static final String SELECT_CONTACT_BY_UID ="SELECT * FROM `contacts` WHERE u_id=?";
	private static final String SELECT_CONTACT_BY_ID ="SELECT `ID`, `Name`, `Email`, `MobileNo`, `Address`, `uID`, `CreateDate` FROM `contacts` WHERE ID=?";
	private static final String UPDATE_CONTACT_BY_ID ="UPDATE `contacts` SET `c_name`=?,`c_email`=?,`c_mobile`=?,`c_groupId`=? `c_isfavourite`=? WHERE c_id=?";
	private static final String SELECT_CONTACT_BY_NAME ="SELECT `ID`, `Name`, `Email`, `MobileNo`, `Address`,`CreateDate` FROM `contacts` WHERE Name=? AND UID=?";
	private static final String DELETE_CONTACT_BY_ID="DELETE FROM `contacts` WHERE c_id=?";
	private static final String UPDATE_USER_PROFILE ="UPDATE `user` SET `ProfileImg`=? WHERE ID=?";
	private static final String SELECT_USER_BY_EMAIL_PSW="Select * from `user` where u_email=? AND u_password=?";
	private static final String SELECT_FAV_CONTACTS ="select * from `contacts` where c_isFavourite=1";
	private static final String SELECT_GRP = "select * from `Groups` where 1";
	Connection con=null; 
	PreparedStatement pstmt;
	public User save(User us) throws SQLException {
		con = DbConnection.getConnection();
		
		if(us.getId()>0)
			 pstmt=con.prepareStatement(INSERT_USER);
		else
		{
			 pstmt = con.prepareStatement(UPDATE_USER);
			pstmt.setInt(4, us.getId());
		}
			pstmt.setString(1,us.getName());
			pstmt.setString(2, us.getEmail());
			pstmt.setString(3, us.getPassward());
			int rs = pstmt.executeUpdate();
		
		return rs>0?us:null;
	}
	
	public User login(String email,String psw) throws SQLException {
		con = DbConnection.getConnection();
		 pstmt = con.prepareStatement(SELECT_USER_BY_EMAIL_PSW);
			pstmt.setString(1,email);
			pstmt.setString(2, psw);
			 ResultSet rs = pstmt.executeQuery();
			 if(rs.next()) {
				 User us = new User();
				 us.setId(rs.getInt(1));
				 us.setName(rs.getString(2));
				 us.setEmail(rs.getString(3));
				 us.setPassward(rs.getString(4));
				 us.setRole(rs.getString(5));
				 return us;
			 }
		  return null;
	}
	

	public boolean addContact(Contacts cont) throws SQLException
	{
		con = DbConnection.getConnection();
		int affected;
		 if(cont.getId()>0)	 
		 {
				pstmt = con.prepareStatement(UPDATE_CONTACT_BY_ID);
				pstmt.setInt(6, cont.getId());
		 }
				// TODO Auto-generated catch block
		 else
		 {
				pstmt = con.prepareStatement(INSERT_CONTACT);
				pstmt.setInt(6, cont.getuId());
		 }
		 
			pstmt.setString(1,cont.getName());
			pstmt.setString(2,cont.getEmail());
			pstmt.setString(3,cont.getMobileNo());
			pstmt.setInt(4,cont.getGroupId());
			pstmt.setBoolean(5, false);
		   affected = pstmt.executeUpdate();
			return affected>0?true:false;		 
	}
	

	public List<Contacts> getContacts(int uId) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_CONTACT_BY_UID);
			pstmt.setInt(1,uId);
			ResultSet rs = pstmt.executeQuery();
			List<Contacts> l = new ArrayList<Contacts>();
			while(rs.next())
			{
				Contacts con = new Contacts();
				con.setId(rs.getInt(1));
				con.setName(rs.getString(2));
				con.setEmail(rs.getString(3));
				con.setMobileNo(rs.getString(4));
				con.setGroupId(rs.getInt(5));
				con.setIsFavourite(rs.getBoolean(6));
				con.setuId(rs.getInt(7));
				l.add(con);
			}
			if(l.size()>0)
			return l;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public List<Contacts> getContacts(int uId,String query) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_CONTACT_BY_UID+query);
			pstmt.setInt(1,uId);
			ResultSet rs = pstmt.executeQuery();
			List<Contacts> l = new ArrayList<Contacts>();
			while(rs.next())
			{
				Contacts con = new Contacts();
				con.setId(rs.getInt(1));
				con.setName(rs.getString(2));
				con.setEmail(rs.getString(3));
				con.setMobileNo(rs.getString(4));
				con.setGroupId(rs.getInt(5));
				con.setIsFavourite(rs.getBoolean(6));
				con.setuId(rs.getInt(7));
				l.add(con);
			}
			if(l.size()>0)
			return l;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public boolean deleteContact(int id) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(DELETE_CONTACT_BY_ID);
			pstmt.setInt(1,id);
			int affected = pstmt.executeUpdate();
			return affected>0?true:false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Contacts> getFavourites() throws SQLException{
		con = DbConnection.getConnection();
		pstmt = con.prepareStatement(SELECT_FAV_CONTACTS);
		ResultSet rs = pstmt.executeQuery();
		List<Contacts> l = new ArrayList<Contacts>();
		while(rs.next())
		{
			Contacts con = new Contacts();
			con.setId(rs.getInt(1));
			con.setName(rs.getString(2));
			con.setEmail(rs.getString(3));
			con.setMobileNo(rs.getString(4));
			con.setGroupId(rs.getInt(5));
			con.setIsFavourite(rs.getBoolean(6));
			con.setuId(rs.getInt(7));
			l.add(con);
		}
		if(l.size()>0)
		return l;
		else
			return null;
	}
	
	public List<Groups> getGroups() throws SQLException{
		con = DbConnection.getConnection();
		pstmt = con.prepareStatement(SELECT_GRP);
		ResultSet rs = pstmt.executeQuery();
		List<Groups> l = new ArrayList<Groups>();
		while(rs.next())
		{
			Groups gp = new Groups();
			gp.setGroupId(rs.getInt(1));
			gp.setGroupName(rs.getString(2));
			gp.setFavourite(rs.getBoolean(3));
			l.add(gp);
		}
		return l.size()>0?l:null;
	} 
	

}
