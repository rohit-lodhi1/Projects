package com.dollop.dao;

import java.sql.SQLException;
import java.util.List;

import com.dollop.entity.Student;

public interface StudentDAO {
   
	public List<Student> get() throws Exception;
	
	public Student get(Integer sID) throws SQLException, Exception;
	
	public boolean save(Student student) throws Exception;
	
	public boolean update(Student student) throws Exception;
	
	public boolean delete(Integer sID) throws Exception;
}
