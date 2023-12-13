package com.dollop.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dollop.dao.StudentDAO;
import com.dollop.db.DbConnection;
import com.dollop.entity.Student;

public class StudentDAOImpl implements StudentDAO {

	private static final String INSERT_STUDENT = "INSERT INTO `student_rec`( `sName`, `sEmail`, `sPassword`, `sContact`, `sAddress`) VALUES (?,?,?,?,?)" ;
	private static final String UPDATE_STUDENT ="UPDATE `student_rec` SET `sName`=?,`sEmail`=?,`sPassword`=?,`sContact`=?,`sAddress`=? WHERE sID=?";
	private static final String SELECT_STUDENTS = "SELECT * FROM `student_rec` WHERE 1";
	private static final String SELECT_STUDENT_BY_ID ="SELECT `sID`, `sName`, `sEmail`, `sPassword`, `sContact`, `sAddress` FROM `student_rec` WHERE sID=?";
	private static final String DELETE_STUDENT ="DELETE FROM `student_rec` WHERE sID=?" ;
	private static final String UPDATE_STUDENT_CONTACT ="UPDATE `student_rec` SET `sContact`=? WHERE sID=?";
	PreparedStatement pstmt = null;
	Connection con=null;
	
	@Override
	public List<Student> get() throws Exception {
		List<Student> studentLists = new ArrayList<Student>();
		con = DbConnection.getConnection();
		pstmt = con.prepareStatement(SELECT_STUDENTS);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			Student student = new Student();
			student.setsId(rs.getInt("sID"));
			student.setsName(rs.getString("sName"));
			student.setsEmail(rs.getString("sEmail"));
			student.setsPassWord(rs.getString("sPassword"));
			student.setsContact(rs.getString("sContact"));
			student.setsAddress(rs.getString("sAddress"));
			studentLists.add(student);
		}
		return studentLists;
	}

	@Override
	public Student get(Integer sID) throws Exception {
		con = DbConnection.getConnection();
		pstmt = con.prepareStatement(SELECT_STUDENT_BY_ID);
	    pstmt.setInt(1, sID);
		ResultSet rs = pstmt.executeQuery();
		Student student = new Student();
		if(rs.next())
		{
			student.setsId(rs.getInt("sID"));
			student.setsName(rs.getString("sName"));
			student.setsEmail(rs.getString("sEmail"));
			student.setsPassWord(rs.getString("sPassword"));
			student.setsContact(rs.getString("sContact"));
			student.setsAddress(rs.getString("sAddress"));
		}	
		return student;
	}

	@Override
	public boolean save(Student student) throws Exception {
	    con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_STUDENT);
		pstmt.setString(1,student.getsName());
		pstmt.setString(2,student.getsEmail());
		pstmt.setString(3,student.getsPassWord());
		pstmt.setString(4,student.getsContact());
		pstmt.setString(5,student.getsAddress());
		int affected =pstmt.executeUpdate();
		return affected>0?true:false;
	}

	@Override
	public boolean update(Student student) throws Exception {
		con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UPDATE_STUDENT);
		pstmt.setString(1,student.getsName());
		pstmt.setString(2,student.getsEmail());
		pstmt.setString(3,student.getsPassWord());
		pstmt.setString(4,student.getsContact());
		pstmt.setString(5,student.getsAddress());
		pstmt.setInt(6,student.getsId());
		int affected = pstmt.executeUpdate();
		return affected>0?true:false;
	}
//	@Override
  /*  public boolean updateStudentContact(String contact,int sID) throws Exception
    {
    	con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UPDATE_STUDENT_CONTACT); 
		pstmt.setString(1,contact);
		pstmt.setInt(2,sID);
		int affected = pstmt.executeUpdate();
		return affected>0?true:false;
    }  */
	@Override
	public boolean delete(Integer sID) throws Exception {
		con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement(DELETE_STUDENT);
		pstmt.setInt(1,sID);
		int affected = pstmt.executeUpdate();
		return affected>0?true:false;
	}

}
