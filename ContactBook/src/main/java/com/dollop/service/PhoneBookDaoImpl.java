package com.dollop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dollop.DAO.PhoneBookDAO;
import com.dollop.Db.DbConnection;
import com.dollop.entity.Contacts;
import com.dollop.entity.User;

public class PhoneBookDaoImpl implements PhoneBookDAO {
	private static final String INSERT_USER = "INSERT INTO `user`(`Name`, `Email`, `Password`, `Contact`,`ProfileImg`) VALUES (?,?,?,?,?)" ;
	private static final String UPDATE_USER_BY_ID ="UPDATE `user` SET `Name`=?,`Email`=?,`Password`=?,`Contact`=? WHERE ID=?";
	private static final String SELECT_USER_BY_ID = "SELECT `ID`, `Name`, `Email`, `Password`, `Contact` FROM `user` WHERE ID=?";
	private static final String UPDATE_USER ="UPDATE `student_rec` SET `sName`=?,`sEmail`=?,`sPassword`=?,`sContact`=?,`sAddress`=? WHERE sID=?";
	private static final String SELECT_USER = "SELECT `ID`, `Name`, `Email`, `Password`,`ProfileImg` FROM `user` WHERE Email=? AND Password=?";
	private static final String SELECT_USER_BY_UNAME ="SELECT `ID`, `uName`, `uEmail`, `uPassword`, `uContact`, `uAddress`, `uStatus` FROM `user` WHERE uName=?";
	private static final String DELETE_USER ="DELETE FROM `student_rec` WHERE sID=?" ;
	private static final String UPDATE_USER_STATUS ="UPDATE `user` SET `uStatus`=? WHERE ID=?";
	private static final String INSERT_CONTACT = "INSERT INTO `contacts`(`Name`, `Email`, `MobileNo`, `Address`, `UID`) VALUES (?,?,?,?,?)";
	private static final String SELECT_CONTACT_BY_UID ="SELECT `ID`, `Name`, `Email`, `MobileNo`, `Address`,`CreateDate` FROM `contacts` WHERE uID=?";
	private static final String SELECT_CONTACT_BY_ID ="SELECT `ID`, `Name`, `Email`, `MobileNo`, `Address`, `uID`, `CreateDate` FROM `contacts` WHERE ID=?";
	private static final String UPDATE_CONTACT_BY_ID ="UPDATE `contacts` SET `Name`=?,`Email`=?,`MobileNo`=?,`Address`=? WHERE ID=?";
	private static final String SELECT_CONTACT_BY_NAME ="SELECT `ID`, `Name`, `Email`, `MobileNo`, `Address`,`CreateDate` FROM `contacts` WHERE Name=? AND UID=?";
	private static final String DELETE_CONTACT_BY_ID="DELETE FROM `contacts` WHERE ID=?";
	private static final String UPDATE_USER_PROFILE ="UPDATE `user` SET `ProfileImg`=? WHERE ID=?";
	PreparedStatement pstmt = null;
	Connection con=null;
	//
	public User login(String email,String password) {
		User us= null;
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				us= new User();
				 us.setId(rs.getInt("ID"));
				 us.setImage(rs.getString("ProfileImg"));
				 System.out.println("inside db"+us);
				 return us;
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("not found");
		}
		return us;
	}

	
	public boolean registration(User u) {
		int affected=0;
		con = DbConnection.getConnection();
		 if(u.getId()>0)
		 {
			 try {
				pstmt = con.prepareStatement(UPDATE_USER_BY_ID);
				pstmt.setString(1,u.getName());
				pstmt.setString(2,u.getEmail());
				pstmt.setString(3,u.getPassword());
				pstmt.setString(4,u.getContact());				
				pstmt.setInt(5, u.getId());
			//	pstmt.setInt(6, cont.getUserId());
			   affected = pstmt.executeUpdate();
				return affected>0?true:false;		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return false;
		 }
		   try{
			 pstmt =con.prepareStatement(INSERT_USER);
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   try {
			pstmt.setString(1,u.getName());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3,u.getPassword());
			pstmt.setString(4,u.getContact());
			pstmt.setString(5,u.getImage());
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
		 
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER_BY_UNAME);
			pstmt.setString(1, us.getName());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				if (rs.getInt("uStatus")==1) 
                       return true;
				
		   }
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int getUser(String name)
	{
		User us = new User();
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER_BY_UNAME);
			pstmt.setString(1,name);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return  rs.getInt("ID");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean addContact(Contacts cont)
	{
		con = DbConnection.getConnection();
		int affected;
		 if(cont.getId()>0)
		 {
			 try {
				pstmt = con.prepareStatement(UPDATE_CONTACT_BY_ID);
				pstmt.setString(1,cont.getName());
				pstmt.setString(2,cont.getEmail());
				pstmt.setString(3,cont.getMobile());
				pstmt.setString(4,cont.getAddress());
				pstmt.setInt(5, cont.getId());
			//	pstmt.setInt(6, cont.getUserId());
			   affected = pstmt.executeUpdate();
				return affected>0?true:false;		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return false;
		 }
		try {
			
			pstmt = con.prepareStatement(INSERT_CONTACT);
			pstmt.setString(1,cont.getName());
			pstmt.setString(2,cont.getEmail());
			pstmt.setString(3,cont.getMobile());
			pstmt.setString(4,cont.getAddress());
			pstmt.setInt(5,cont.getUserId());
			 affected = pstmt.executeUpdate();
			return affected>0?true:false;
			
		}catch(Exception e)
		{
		  e.printStackTrace();	
		}
		return false;
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
				con.setId(rs.getInt("ID"));
				con.setName(rs.getString("Name"));
				con.setEmail(rs.getString("Email"));
				con.setMobile(rs.getString("MobileNo"));
				con.setAddress(rs.getString("Address"));
				con.setDate(rs.getString("CreateDate"));
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
				con.setId(rs.getInt("ID"));
				con.setName(rs.getString("Name"));
				con.setEmail(rs.getString("Email"));
				con.setMobile(rs.getString("MobileNo"));
				con.setAddress(rs.getString("Address"));
				con.setDate(rs.getString("CreateDate"));
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

	public Contacts getContact(int id)
	{
		Contacts c= new Contacts();
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_CONTACT_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				c.setId(rs.getInt("ID"));
				c.setUserId(rs.getInt("uID"));
				c.setName(rs.getString("Name"));
				c.setEmail(rs.getString("Email"));
				c.setAddress(rs.getString("Address"));
				c.setMobile(rs.getString("MobileNo"));
				c.setDate(rs.getString("CreateDate"));
			}
			
		}catch(Exception e)
		{
			
		}
		return c;
	}
	
	public boolean updateContact(Contacts c) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(UPDATE_CONTACT_BY_ID);
			pstmt.setString(1,c.getName());
			pstmt.setString(2,c.getEmail());
			pstmt.setString(3,c.getMobile());
			pstmt.setString(4,c.getAddress());
			pstmt.setInt(5,c.getId());
			int affected = pstmt.executeUpdate();
			return affected>0?true:false;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Contacts> getContact(String name,int uid) {
		List<Contacts> l = new ArrayList<Contacts>();
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_CONTACT_BY_NAME);
			pstmt.setString(1, name);
			pstmt.setInt(2, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			Contacts c = new Contacts();
			c.setName(rs.getString("Name"));
			c.setEmail(rs.getString("Email"));
			c.setAddress(rs.getString("Address"));
			c.setMobile(rs.getString("MobileNo"));
			c.setDate(rs.getString("CreateDate"));
			c.setId(rs.getInt("ID"));
			l.add(c);
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


	@Override
	public User getUser(int id) {
	User us =null;
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(SELECT_USER_BY_ID);
			pstmt.setInt(1, id);
			 ResultSet rs= pstmt.executeQuery();
			 if(rs.next())
			 {
				 us=new User();
				 us.setId(rs.getInt("ID"));
				 us.setName(rs.getString("Name"));
				 us.setEmail(rs.getString("Email"));
				 us.setContact(rs.getString("Contact"));
				 us.setPassword(rs.getString("Password"));
			 }
			return us;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return us;
	}


	@Override
	public boolean uploadImg(int id, String img) {
		try {
			con = DbConnection.getConnection();
			pstmt = con.prepareStatement(UPDATE_USER_PROFILE);
			pstmt.setString(1, img);
			pstmt.setInt(2, id);
			int affected = pstmt.executeUpdate();
			return affected>0?true:false;
			}catch(Exception e) {e.printStackTrace();}	
		return false;
	}
	
}
