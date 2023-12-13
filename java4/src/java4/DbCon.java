package java4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbCon {
private static final String DB_USER="root";
private static final String DB_PSW="";
private static final String DB_DRIVER= "com.mysql.cj.jdbc.Driver";
private static final String DB_URL="jdbc:mysql://localhost:3306/jdbcdemo";
private static final String INSERT_EMP="INSERT INTO `emp`( `Ename`, `Salary`) VALUES ('ANKIT','40000')";
private static final String UPDATE_EMP="UPDATE `emp` SET `ID`='1' WHERE ID=NULL";
private static final String DELETE_EMP="DELETE FROM `emp` WHERE 0";
private static final String SELECT_EMP="SELECT * FROM `emp` WHERE 1";
	
	public static void main(String[] args)throws Exception{
        // load Driver
		Class.forName(DB_DRIVER);
		//set Connection
		Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PSW);
		///create Statement
		Statement stmt = con.createStatement();
		// execute query
		int affected = stmt.executeUpdate(UPDATE_EMP);
		System.out.println(affected+"affected");
     con.close();
	}

}
