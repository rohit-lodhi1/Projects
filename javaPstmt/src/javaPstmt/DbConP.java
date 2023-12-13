package javaPstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConP {

	private static final String DB_USER="root";
	private static final String DB_PSW="";
	private static final String DB_URL="jdbc:mysql://localhost:3306/jdbcdemo";
	private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String INSERT_CAR = "INSERT INTO `car`(`CarName`, `CarPrice`) VALUES (?,?)";
	private static final String DELETE_CAR =  "DELETE FROM `car` WHERE MNo=?";
	private static final String SELECT_CAR = "SELECT * FROM `car` WHERE 1";
	private static final String UPDATE_CAR = "UPDATE `car` SET `CarPrice`=? WHERE MNo=?";
	
	public static void main(String[] args)throws Exception {
	// load Driver
		Class.forName(DB_DRIVER);
     // set COnnection
		Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PSW);
		// prepare statement
		PreparedStatement pstmt = con.prepareStatement(SELECT_CAR);
		//pstmt.setString(1,"" );
	//	pstmt.setInt(1, 1300000);
		//pstmt.setInt(1,3);
		//execute
		  // int affected =pstmt.executeUpdate();
		 //  System.out.println(affected +"affected");
		 
		ResultSet rs = pstmt.executeQuery();
		  while(rs.next())
		  {
			  System.out.println(rs.getInt("MNo"));
			  System.out.println(rs.getString("CarName"));
			  System.out.println(rs.getString("CarPrice"));
		  }
	}

}
