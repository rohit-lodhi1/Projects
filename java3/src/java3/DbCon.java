package java3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbCon {
   
	private static final String DB_USER = "root";
	private static final String DB_PSW = "";
	private static final String DB_URL="jdbc:mysql://localhost:3306/jdbcdemo";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String INSERT_CAR = "INSERT INTO `car`(`CarName`, `CarPrice`) VALUES ('TATA','400000')";
	private static final String UPDATE_CAR = "UPDATE `car` SET `CarName`='TATA' WHERE MNo=1";
	private static final String DELETE_CAR = "DELETE FROM `car` WHERE MNO=1";
	private static final String SELECT_CAR = "SELECT * FROM `car` WHERE 1"; 
	public static void main(String[] args)throws Exception {
		// load Driver
		Class.forName(DB_DRIVER);
      // set Connection
		Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PSW);
    	// create statement
		Statement stmt = con.createStatement();
		//execute queuery
		//int affected=stmt.executeUpdate(INSERT_CAR);
		//System.out.pr intln(affected+"affected rows");
		ResultSet rs= stmt.executeQuery(SELECT_CAR);
		while(rs.next())
		{
			System.out.print(rs.getInt("MNO")+"  ");
			System.out.print(rs.getString("CarName")+"  ");
			System.out.println(rs.getInt("CarPrice")+"  ");
		}
		con.close();
	}

}
