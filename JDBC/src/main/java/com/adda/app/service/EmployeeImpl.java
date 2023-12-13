package com.adda.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import com.adda.app.DbConnection;
import com.adda.app.entity.Address;
import com.adda.app.entity.Employee;


public class EmployeeImpl {

	private Connection con;
	private static final StringBuilder SelectEmpByWorkLocation=new StringBuilder("Select * from employee where workLocaton in (");
    private static final String SelectBtwJoinDate="Select * from employee where JoinDate Between ? And ?";
	private static final String INSERT_EMP = "Insert into employee (emp_name,emp_salary,workLocation) values(?,?,?)";
	private static final String UPLOAD_IMG ="insert into images (img_name,image) values(?,?)";
	private static final String INS_EMP="Insert into employee (emp_name,emp_salary,workLocation) values(?,?,?)";
	private static final String INS_ADD="Insert into employee (emp_name,emp_salary,workLocation) values(?,?,?);insert into emp_address values((select emp_id from employee where emp_name=? AND emp_salary=?),?,?,?)";
    private static final String CALL_PRO ="call getEmp(?)";	
	private static final String CALL_NAME ="{call getEmpByName(?,?)";		
	
	public Employee getEmp(int id) {
		Employee emp = new Employee();
		   con = DbConnection.getConnection();
		   try {
			CallableStatement pstmt= con.prepareCall(CALL_PRO);
			pstmt.setInt(1,id);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			emp.setEmp_name(rs.getString("emp_name"));
			return emp;
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	public Employee getEmpName(String name) {
		Employee emp = new Employee();
		   con = DbConnection.getConnection();
		   try { 
			CallableStatement pstmt= con.prepareCall(CALL_NAME);
			pstmt.setString(1,name);
	   	pstmt.registerOutParameter(2, Types.VARCHAR);
			pstmt.setString(2, "workLocation");
		    pstmt.executeUpdate();
			
			emp.setEmp_name( pstmt.getString("workLocation"));
			
			return emp;
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	
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
	
	
	
	public boolean addEmp(Employee emp) {
		try {
		con = DbConnection.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_EMP);
		pstmt.setString(1, emp.getEmp_name());
		pstmt.setInt(2, emp.getEmp_salary());
		pstmt.setString(3, emp.getWorkLocaton());
		if( pstmt.executeUpdate()>0)
		{
			
			pstmt.setString(1, emp.getEmp_name());
			pstmt.setInt(2, emp.getEmp_salary());
		
			pstmt.setString(3, emp.getAddress().getCity());
			pstmt.setString(4, emp.getAddress().getState());
			pstmt.setString(5, emp.getAddress().getCountry());
			pstmt.execute();
		}
		
		
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	
	
	
	// <------Bulkupload Through Statement------>
	public boolean addBulkEmployeeByStatement(List<Employee> empList) {
		con = DbConnection.getConnection();
		   String INSERT_EMP_BY_Stmt ;
		try {
			Statement stmt = con.createStatement();
			for(int i=0;i<empList.size();i++) {
				
				INSERT_EMP_BY_Stmt = "Insert into employee (emp_name,emp_salary,workLocation) values('"+empList.get(i).getEmp_name()+"',"+empList.get(i).getEmp_salary()+",'"+empList.get(i).getWorkLocaton()+"')";
				stmt.addBatch(INSERT_EMP_BY_Stmt);
			}
			int[] ar=stmt.executeBatch();
			return ar.length>0;
			
			
		} catch (SQLException e) {e.printStackTrace();}
     return false;		
	}
	
	
	
	
	
	
	// <------Bulkupload Through PrepareStatement------>
	public boolean addBulkEmployee(List<Employee> empList) {
		con = DbConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT_EMP);
			
			for(int i=0;i<empList.size();i++) {
				pstmt.setString(1, empList.get(i).getEmp_name());
				pstmt.setInt(2, empList.get(i).getEmp_salary());
				pstmt.setString(3, empList.get(i).getWorkLocaton());
				pstmt.addBatch();
			}
			int[] ar=pstmt.executeBatch();
			return ar.length>0;
			
			
		} catch (SQLException e) {e.printStackTrace();}
     return false;		
	}
	
	
	public List<Employee> getEmployeeAccToJoinDate(String start,String last){
		List<Employee> l = new ArrayList<Employee>();
		try {
			con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(SelectBtwJoinDate);
			System.out.println(pstmt);
			pstmt.setString(1, start);
			pstmt.setString(2, last);
			 ResultSet rs= pstmt.executeQuery();
			 while(rs.next())
			 {
					Employee e = new Employee();
					e.setEmp_id(rs.getInt("emp_id"));
					e.setEmp_name(rs.getString("emp_name"));
					e.setEmp_salary(rs.getInt("emp_salary"));
					e.setWorkLocaton(rs.getString("workLocation"));
					e.setJoinDate(rs.getString("JoinDate"));
					l.add(e);
			 }
			
		}catch (Exception e) {
             e.printStackTrace();
		}
		
		return l;
	}
	
	
	public List<Employee> getEmployeeByWorkLocation(String location[]) {

		List<Employee> l = new ArrayList<Employee>();
		for (int i = 0; i < location.length; i++) 
			SelectEmpByWorkLocation.append("?,");
		
		
		SelectEmpByWorkLocation.append(")").deleteCharAt(SelectEmpByWorkLocation.length() - 2);
		
		con = DbConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(SelectEmpByWorkLocation.toString());
			System.out.println(SelectEmpByWorkLocation);
			for (int i = 0; i < location.length; i++) 
				pstmt.setString(i + 1, location[i]);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmp_id(rs.getInt("emp_id"));
				e.setEmp_name(rs.getString("emp_name"));
				e.setEmp_salary(rs.getInt("emp_salary"));
				e.setWorkLocaton(rs.getString("workLocation"));
				e.setJoinDate(rs.getString("JoinDate"));
				l.add(e);
			}
		} catch (SQLException e) {e.printStackTrace();}
		return l;
	}
	
	
	
	public static final StringBuilder  EMP_FILTER = new StringBuilder("select * from employee where 1");
	
	public List<Employee> EmpFilter(String name,String salary,String workLocation){
		List<Employee> l = new ArrayList<Employee>();
		if(name!=null && !name.equals("null")  && !name.equals("NULL"))
	    EMP_FILTER.append(" AND emp_name = ?");
		if(salary!=null && !salary.equals("null")  && !salary.equals("NULL"))
		    EMP_FILTER.append(" AND emp_salary = ?");
		if(workLocation!=null && !workLocation.equals("null")  && !workLocation.equals("NULL"))
		    EMP_FILTER.append(" AND workLocation = ?");
		try {
			con =  DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(EMP_FILTER.toString());
			int ind=1;
			if(name!=null && !name.equals("null")  && !name.equals("NULL"))
			    pstmt.setString(ind++, name);
				if(salary!=null && !salary.equals("null")  && !salary.equals("NULL"))
					pstmt.setString(ind++, salary);
				if(workLocation!=null && !workLocation.equals("null")  && ! workLocation.equals("NULL"))
					pstmt.setString(ind++, workLocation);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
        	 Employee e = new Employee();
				e.setEmp_id(rs.getInt("emp_id"));
				e.setEmp_name(rs.getString("emp_name"));
				e.setEmp_salary(rs.getInt("emp_salary"));
				e.setWorkLocaton(rs.getString("workLocation"));
				e.setJoinDate(rs.getString("JoinDate"));
				
				l.add(e);
         }
			return l;
		} catch (SQLException e) {e.printStackTrace();}	
		
		return null;
	}
	
}
